package kg.java.purchase.domain.facades;

import jakarta.transaction.Transactional;
import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.contracts.facades.ProductFacade;
import kg.java.purchase.core.contracts.services.ProductService;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductFacadeImpl implements ProductFacade {
    private final ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto add(CreateProductDto model) throws EntityDuplicateException {
        return productService.add(model);
    }

    @Override
    public ProductDto update(UpdateProductDto model) throws EntityNotFoundException {
        return productService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        return productService.delete(model);
    }

    @Override
    public ProductDto findById(FindByIdProductDto model) throws EntityNotFoundException {
        return productService.findById(model);
    }
}
