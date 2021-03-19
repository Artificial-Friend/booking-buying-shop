package registration.booking.service.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private LocalDateTime localDateTime;
    private BigDecimal price;
    private BigDecimal priceWithDiscount;
    private List<OrderDetailsResponseDto> orderDetails;
}
