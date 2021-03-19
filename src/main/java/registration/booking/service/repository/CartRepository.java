package registration.booking.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import registration.booking.service.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
