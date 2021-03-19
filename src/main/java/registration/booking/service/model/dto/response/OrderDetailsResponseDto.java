package registration.booking.service.model.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderDetailsResponseDto {
    private String productName;
    private int quantity;
    private BigDecimal price;
}
