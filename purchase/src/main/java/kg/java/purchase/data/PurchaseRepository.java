package kg.java.purchase.data;


import kg.java.purchase.core.models.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {
  @Query("select p from PurchaseEntity p " +
          "where p.buyer.name=:buyerName" +
          " order by p.id")
    List<PurchaseEntity> findByBuyerName(@Param("buyerName")String buyerName);

}
