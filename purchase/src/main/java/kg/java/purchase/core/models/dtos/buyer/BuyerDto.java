package kg.java.purchase.core.models.dtos.buyer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyerDto {
    private Long id;
    private String name;
    private String email;

}
