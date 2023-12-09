package kg.java.purchase.core.models.dtos.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByBuyerNameDto {
    private String buyerName;
}
