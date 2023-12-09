package kg.java.purchase.domain.facades;

import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.contracts.facades.PurchaseFacade;
import kg.java.purchase.core.contracts.services.PurchaseService;
import kg.java.purchase.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseFacadeImpl implements PurchaseFacade {
    private final PurchaseService purchaseService;

    public PurchaseFacadeImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.add(model);
    }

    @Override
    public PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException {
        return purchaseService.update(model);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.delete(model);
    }

    @Override
    public PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException {
        return purchaseService.findById(model);
    }

    @Override
    public List<PurchaseDto> findByBuyerName(FindByBuyerNameDto model) {
        return purchaseService.findByBuyerName(model);
    }
}
