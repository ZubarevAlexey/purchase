package kg.java.purchase.core.contracts.services;

import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;

public interface PurchaseService {
    PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException;
    HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException;
}
