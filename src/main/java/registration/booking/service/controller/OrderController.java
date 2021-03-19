package registration.booking.service.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import registration.booking.service.model.Order;
import registration.booking.service.model.dto.response.OrderDetailsResponseDto;
import registration.booking.service.model.dto.response.OrderResponseDto;
import registration.booking.service.service.OrderService;
import registration.booking.service.service.dto.mapper.OrderDetailsResponseMapper;
import registration.booking.service.service.dto.mapper.OrderResponseMapper;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderDetailsResponseMapper orderDetailsResponseMapper;

    @PutMapping("/client/{clientId}/complete-order")
    public ResponseEntity<OrderResponseDto> completeOrder(@PathVariable Long clientId) {
        Order order = orderService.completeOrder(clientId);
        List<OrderDetailsResponseDto> orderDetailsResponseDtos = order.getOrderDetails().stream()
                .map(orderDetailsResponseMapper::map)
                .collect(Collectors.toList());
        OrderResponseDto orderResponseDto = orderResponseMapper.map(order);
        orderResponseDto.setOrderDetails(orderDetailsResponseDtos);
        return ResponseEntity.ok(orderResponseDto);
    }
}
