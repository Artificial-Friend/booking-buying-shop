package registration.booking.service.util;

import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import registration.booking.service.model.Client;
import registration.booking.service.model.Product;
import registration.booking.service.service.ClientService;
import registration.booking.service.service.OrderService;
import registration.booking.service.service.ProductService;

@Component
@AllArgsConstructor
public class AutoInjectMockData {
    private final ClientService clientService;
    private final OrderService orderService;
    private final ProductService productService;

    @PostConstruct
    public void init() {
        Client client = new Client();
        client.setEmail("email@email");
        client.setName("bob");
        clientService.register(client);
        Client client1 = new Client();
        client1.setEmail("wwww@wwww");
        client1.setName("alice");
        clientService.register(client1);

        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(20));
        product.setName("potato");
        product.setQuantity(500);
        productService.createOrUpdate(product);
        Product product1 = new Product();
        product1.setPrice(BigDecimal.valueOf(10));
        product1.setName("tomato");
        product1.setQuantity(200);
        productService.createOrUpdate(product1);
        Product product2 = new Product();
        product2.setPrice(BigDecimal.valueOf(40));
        product2.setName("pants");
        product2.setQuantity(50);
        productService.createOrUpdate(product2);
    }
}
