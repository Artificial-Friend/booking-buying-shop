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

    @Query(value = "SELECT od.product FROM OrderDetails od "
            + "JOIN FETCH Product p ON od.product.id = p.id "
            + "GROUP BY od.product ORDER BY od.quantity DESC")
    List<Product> getOrderedByPopularity();
}
