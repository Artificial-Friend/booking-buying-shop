package registration.booking.service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import registration.booking.service.model.Cart;
import registration.booking.service.model.Client;
import registration.booking.service.repository.CartRepository;
import registration.booking.service.repository.ClientRepository;
import registration.booking.service.service.ClientService;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final CartRepository cartRepository;

    @Override
    public void register(Client client) {
        client.setDiscount((byte) 5);
        Cart cart = new Cart();
        cart.setClient(client);
        cartRepository.save(cart);
        clientRepository.save(client);
    }

    @Override
    public Client get(Long id) {
        return clientRepository.findById(id).orElseThrow(()
                -> new RuntimeException("ERROR: there is no client with id " + id));
    }
}
