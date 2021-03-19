package registration.booking.service.service;

import registration.booking.service.model.Cart;

public interface CartService {
    Cart createOrUpdate(Cart cart);

    Cart find(Long id);
}
