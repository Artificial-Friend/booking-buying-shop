package registration.booking.service.service.dto.mapper;

import org.springframework.stereotype.Component;
import registration.booking.service.model.OrderDetails;
import registration.booking.service.model.dto.response.OrderDetailsResponseDto;

@Component
public class OrderDetailsResponseMapper {
    public OrderDetailsResponseDto map(OrderDetails orderDetails) {
        OrderDetailsResponseDto dto = new OrderDetailsResponseDto();
        dto.setPrice(orderDetails.getPrice());
        dto.setProductName(orderDetails.getProduct().getName());
        dto.setQuantity(orderDetails.getQuantity());
        dto.setPrice(orderDetails.getPrice());
        return dto;
    }
}
