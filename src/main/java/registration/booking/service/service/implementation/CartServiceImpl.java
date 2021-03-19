package registration.booking.service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import registration.booking.service.model.Cart;
import registration.booking.service.repository.CartRepository;
import registration.booking.service.service.CartService;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart createOrUpdate(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart find(Long id) {
        return cartRepository.findById(id).orElseThrow(()
                -> new RuntimeException("ERROR: cart with id " + id + " does not exist!"));
    }
}
