package ma.nemo.assignment.repository;

import ma.nemo.assignment.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    // You can add custom query methods if needed
}