package kg.java.purchase.domain.services;

import jakarta.transaction.Transactional;
import kg.java.purchase.core.exceptions.EntityNotFoundException;
import kg.java.purchase.core.contracts.services.ProductService;
import kg.java.purchase.core.exceptions.EntityDuplicateException;
import kg.java.purchase.core.mappers.ProductMapper;
import kg.java.purchase.core.models.dtos.product.*;
import kg.java.purchase.data.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto add(CreateProductDto model) throws EntityDuplicateException {
        var product = productRepository.findByName(model.getName());
        if (product.isPresent()) throw new EntityDuplicateException();
        var entity = productRepository.save(productMapper.fromDomain(model)) ;
        return productMapper.toDomain(entity);
    }

    @Override
    public ProductDto update(UpdateProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = product.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .coast(model.getCoast())
                .build();
        productRepository.save(entity);
        return productMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        productRepository.delete(product);
        return HttpStatus.OK;
    }

    @Override
    public ProductDto findById(FindByIdProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return productMapper.toDomain(product);
    }
}
