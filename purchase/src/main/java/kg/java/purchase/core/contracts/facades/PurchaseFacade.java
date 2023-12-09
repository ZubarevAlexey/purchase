package kg.java.purchase.core.contracts.facades;


import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface PurchaseFacade {
    PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException;
    HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException;
    List<PurchaseDto> findByBuyerName(FindByBuyerNameDto model);
}
