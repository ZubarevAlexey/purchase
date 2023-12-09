package kg.java.purchase.core.mappers.base;


import kg.java.purchase.core.mappers.BuyerMapper;
import kg.java.purchase.core.mappers.ProductMapper;
import kg.java.purchase.core.mappers.PurchaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public BuyerMapper buildBuyerMapper() {
        return new BuyerMapper();
    }
    @Bean
    ProductMapper buildProductMapper() {
        return new ProductMapper();
    }
    @Bean
    PurchaseMapper buildPurchaseMapper() {
        return new PurchaseMapper();
    }

}
