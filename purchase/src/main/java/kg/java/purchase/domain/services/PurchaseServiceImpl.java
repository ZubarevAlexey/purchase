package kg.java.purchase.domain.services;

import jakarta.transaction.Transactional;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.contracts.services.PurchaseService;
import kg.java.purchase.core.mappers.PurchaseMapper;
import kg.java.purchase.core.models.dtos.purchase.*;
import kg.java.purchase.data.BuyerRepository;
import kg.java.purchase.data.ProductRepository;
import kg.java.purchase.data.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

   private final BuyerRepository buyerRepository;
   private final ProductRepository productRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper,
                               BuyerRepository buyerRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var entity =purchaseMapper.fromDomain(model);
        entity.setBuyer(buyer);
        entity.setProduct(product);
        purchaseRepository.save(entity);
        return purchaseMapper.toDomain(entity);
    }

    @Override
    public PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var entity =purchase.toBuilder()
                .id(model.getId())
                .datePurchase(model.getDatePurchases())
                .buyer(buyer)
                .product(product)
                .build();
        purchaseRepository.save(entity);
        return purchaseMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        purchaseRepository.delete(purchase);
        return HttpStatus.OK;
    }

    @Override
    public PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return purchaseMapper.toDomain(purchase);
    }

    @Override
    public List<PurchaseDto> findByBuyerName(FindByBuyerNameDto model) {
        var purchases = purchaseRepository.findByBuyerName(model.getBuyerName());
        return purchases.stream().map(purchaseMapper::toDomain).collect(Collectors.toList());
    }
}
