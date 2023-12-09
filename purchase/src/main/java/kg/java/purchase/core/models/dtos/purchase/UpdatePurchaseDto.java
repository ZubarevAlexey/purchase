package kg.java.purchase.core.models.dtos.purchase;


import kg.java.purchase.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePurchaseDto extends BaseDto {
    private Long buyerId;
    private Long productId;
    private Date datePurchases;
}
