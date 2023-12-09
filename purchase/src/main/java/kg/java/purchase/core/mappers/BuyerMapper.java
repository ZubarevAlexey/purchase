package kg.java.purchase.core.mappers;


import kg.java.purchase.core.models.dtos.buyer.BuyerDto;
import kg.java.purchase.core.models.dtos.buyer.CreateBuyerDto;
import kg.java.purchase.core.models.dtos.buyer.UpdateBuyerDto;
import kg.java.purchase.core.models.entities.BuyerEntity;


public class BuyerMapper {
    public BuyerDto toDomain(BuyerEntity model) {
        return BuyerDto.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }
    public BuyerEntity fromDomain(CreateBuyerDto model) {
        return BuyerEntity.builder()
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }
    public BuyerEntity fromDomain(UpdateBuyerDto model) {
        return BuyerEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }
}
