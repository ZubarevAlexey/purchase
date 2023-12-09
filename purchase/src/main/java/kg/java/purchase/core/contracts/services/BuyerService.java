package kg.java.purchase.core.contracts.services;


import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;


public interface BuyerService {
    BuyerDto register(CreateBuyerDto model) throws EntityDuplicateException;

    BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException;

    BuyerDto findById(FindByIdBuyerDto model) throws EntityNotFoundException;



}
