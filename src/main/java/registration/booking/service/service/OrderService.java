package registration.booking.service.service;

import registration.booking.service.model.Order;

public interface OrderService {
    Order completeOrder(Long clientId);
}
