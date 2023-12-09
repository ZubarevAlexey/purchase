package kg.java.purchase.core.contracts.services;


import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;

public interface ProductService {
    ProductDto add(CreateProductDto model) throws EntityDuplicateException;

    ProductDto update(UpdateProductDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException;

    ProductDto findById(FindByIdProductDto model) throws EntityNotFoundException;
}
