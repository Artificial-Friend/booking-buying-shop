package registration.booking.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import registration.booking.service.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
