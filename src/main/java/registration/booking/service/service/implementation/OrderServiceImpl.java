package registration.booking.service.service.implementation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import registration.booking.service.model.Cart;
import registration.booking.service.model.Client;
import registration.booking.service.model.Order;
import registration.booking.service.model.OrderDetails;
import registration.booking.service.repository.CartRepository;
import registration.booking.service.repository.ClientRepository;
import registration.booking.service.repository.OrderDetailsRepository;
import registration.booking.service.repository.OrderRepository;
import registration.booking.service.service.OrderService;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final CartRepository cartRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public Order completeOrder(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(()
                -> new RuntimeException("ERROR: there is no client with id " + clientId));
        Order order = new Order();
        order.setClient(client);
        Cart cart = cartRepository.findById(clientId).get();
        List<OrderDetails> orderDetails = moveBookedProductsToOrderDetails(cart);
        cart.setBookedProducts(new HashMap<>());
        cartRepository.save(cart);
        order.setOrderDetails(orderDetails);
        orderRepository.save(order);
        return order;
    }

    private List<OrderDetails> moveBookedProductsToOrderDetails(Cart cart) {
        List<OrderDetails> orderDetails = new ArrayList<>();
        cart.getBookedProducts().forEach((k, v) -> {
            OrderDetails orderDetails1 = new OrderDetails();
            orderDetails1.setProduct(k);
            orderDetails1.setQuantity(v);
            orderDetails1.setPrice(k.getPrice().multiply(BigDecimal.valueOf(v)));
            orderDetails.add(orderDetails1);
            orderDetailsRepository.save(orderDetails1);
        });
        return orderDetails;
    }
}
