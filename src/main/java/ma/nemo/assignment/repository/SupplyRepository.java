package ma.nemo.assignment.repository;

import ma.nemo.assignment.domain.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    // You can add custom query methods if needed
}