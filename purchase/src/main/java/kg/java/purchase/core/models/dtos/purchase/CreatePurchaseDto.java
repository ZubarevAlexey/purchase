package kg.java.purchase.core.models.dtos.purchase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePurchaseDto {
    private Long buyerId;
    private Long productId;
    private Date datePurchases;
}
