package kg.java.purchase.core.models.dtos.buyer;

import kg.java.purchase.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBuyerDto extends BaseDto {
    private String name;
    private String email;

}
