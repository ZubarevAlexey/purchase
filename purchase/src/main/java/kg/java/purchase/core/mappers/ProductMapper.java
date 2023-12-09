package kg.java.purchase.core.mappers;

import kg.java.purchase.core.models.dtos.product.CreateProductDto;
import kg.java.purchase.core.models.dtos.product.ProductDto;
import kg.java.purchase.core.models.dtos.product.UpdateProductDto;
import kg.java.purchase.core.models.entities.ProductEntity;

public class ProductMapper {
    public ProductDto toDomain(ProductEntity model){
        return ProductDto.builder()
                .id(model.getId())
                .coast(model.getCoast())
                .name(model.getName())
                .build();
    }
    public ProductEntity fromDomain(CreateProductDto model){
        return ProductEntity.builder()
                .name(model.getName())
                .coast(model.getCoast())
                .build();
    }
    public ProductEntity fromDomain(UpdateProductDto model){
        return ProductEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .coast(model.getCoast())
                .build();
    }
}
