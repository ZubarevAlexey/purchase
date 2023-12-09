package kg.java.purchase.domain.services;

import jakarta.transaction.Transactional;
import kg.java.purchase.core.contracts.services.BuyerService;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.mappers.BuyerMapper;
import kg.java.purchase.core.models.dtos.buyer.*;
import kg.java.purchase.data.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;
    private final BuyerMapper buyerMapper;

    public BuyerServiceImpl(BuyerRepository buyerRepository, BuyerMapper buyerMapper) {
        this.buyerRepository = buyerRepository;
        this.buyerMapper = buyerMapper;
    }

    @Override
    public BuyerDto register(CreateBuyerDto model) throws EntityDuplicateException {
        var buyer = buyerRepository.findByName(model.getName());
        if (buyer.isPresent()) throw new EntityDuplicateException();
        var entity = buyerMapper.fromDomain(model);
        buyerRepository.save(entity);
        return buyerMapper.toDomain(entity);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = buyer.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .build();
        buyerRepository.save(entity);
        return buyerMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        buyerRepository.delete(buyer);
        return HttpStatus.OK;
    }

    @Override
    public BuyerDto findById(FindByIdBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return buyerMapper.toDomain(buyer);
    }

}
