package registration.booking.service.service;

import registration.booking.service.model.Client;

public interface ClientService {
    void register(Client client);

    Client get(Long id);
}
