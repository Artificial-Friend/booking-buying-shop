package registration.booking.service.service;

import java.util.List;
import registration.booking.service.model.Product;

public interface ProductService {
    void createOrUpdate(Product product);

    Product findByName(String name);

    List<Product> findAllOrderedByMostExpensive();

    List<Product> findAllOrderedByPopularity();

    List<Product> findAllOrderedByCheapest();
}
