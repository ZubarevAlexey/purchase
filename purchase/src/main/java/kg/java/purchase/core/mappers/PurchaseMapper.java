package kg.java.purchase.core.mappers;


import kg.java.purchase.core.models.dtos.buyer.BuyerDto;
import kg.java.purchase.core.models.dtos.product.ProductDto;
import kg.java.purchase.core.models.dtos.purchase.CreatePurchaseDto;
import kg.java.purchase.core.models.dtos.purchase.PurchaseDto;
import kg.java.purchase.core.models.dtos.purchase.UpdatePurchaseDto;
import kg.java.purchase.core.models.entities.PurchaseEntity;

public class PurchaseMapper {
    public PurchaseDto toDomain(PurchaseEntity model){
        var buyer = model.getBuyer();
        var product = model.getProduct();
        return  PurchaseDto.builder()
                .id(model.getId())
                .datePurchases(model.getDatePurchase())
                .buyer(BuyerDto.builder()
                        .name(buyer.getName())
                        .email(buyer.getEmail())
                        .build())
                .product(ProductDto.builder()
                        .name(product.getName())
                        .coast(product.getCoast())
                        .build()
                ).build();
    }
    public PurchaseEntity fromDomain(CreatePurchaseDto model){
        return PurchaseEntity.builder()
                .datePurchase(model.getDatePurchases())
                .build();
    }
    public PurchaseEntity fromDomain(UpdatePurchaseDto model){
        return PurchaseEntity.builder()
                .id(model.getId())
                .datePurchase(model.getDatePurchases())
                .build();
    }

}
