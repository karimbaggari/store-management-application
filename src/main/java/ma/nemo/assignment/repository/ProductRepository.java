package ma.nemo.assignment.repository;

import ma.nemo.assignment.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByExpirationDateBetween(Date startDate, Date endDate);
  @Query("SELECT p FROM Product p WHERE p.quantityInStock < p.thresholdQuantity")
  List<Product> findProductsBelowThreshold();

  @Query("SELECT p FROM Product p WHERE p.productCode = :productCode")
  Product findByProductCode(@Param("productCode") String productCode);

}