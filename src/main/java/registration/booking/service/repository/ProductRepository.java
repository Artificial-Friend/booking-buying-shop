package registration.booking.service.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import registration.booking.service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    @Query(value = "SELECT p FROM Product p "
            + "LEFT JOIN FETCH OrderDetails od ON od.product.id = p.id "
            + "GROUP BY p.id ORDER BY od.quantity DESC")
    List<Product> getOrderedByPopularity();
}
