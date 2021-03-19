package registration.booking.service.service.dto.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import registration.booking.service.model.Order;
import registration.booking.service.model.OrderDetails;
import registration.booking.service.model.dto.response.OrderResponseDto;

@Component
@AllArgsConstructor
public class OrderResponseMapper {
    private final OrderDetailsResponseMapper orderDetailsResponseMapper;

    public OrderResponseDto map(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        List<OrderDetails> orderDetails = order.getOrderDetails();
        responseDto.setOrderDetails(orderDetails.stream()
                .map(orderDetailsResponseMapper::map)
                .collect(Collectors.toList()));
        BigDecimal price = orderDetails.stream()
                .map(OrderDetails::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        responseDto.setPrice(price);
        BigDecimal priceWithDiscount;
        byte discount = order.getClient().getDiscount();
        if (discount != 0) {
            priceWithDiscount = price.subtract(price.multiply(BigDecimal.valueOf(
                    (double) discount / 100))).setScale(2, RoundingMode.HALF_UP);
            responseDto.setPriceWithDiscount(priceWithDiscount);
        } else {
            responseDto.setPriceWithDiscount(price);
        }
        responseDto.setLocalDateTime(LocalDateTime.now());
        return responseDto;
    }
}
