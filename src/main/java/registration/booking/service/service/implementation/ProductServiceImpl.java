package registration.booking.service.service.implementation;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import registration.booking.service.model.Product;
import registration.booking.service.repository.ProductRepository;
import registration.booking.service.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createOrUpdate(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name).orElseThrow(()
                -> new RuntimeException("ERROR: no such product like " + name));
    }

    @Override
    public List<Product> findAllOrderedByMostExpensive() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    @Override
    public List<Product> findAllOrderedByPopularity() {
        return productRepository.getOrderedByPopularity();
    }

    @Override
    public List<Product> findAllOrderedByCheapest() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }
}
