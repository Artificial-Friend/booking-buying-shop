package registration.booking.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import registration.booking.service.model.Client;
import registration.booking.service.service.ClientService;

@Controller
@RequestMapping
@AllArgsConstructor
public class AuthorizationController {
    private final ClientService clientService;

    @PostMapping("/register")
    public void register(@RequestParam String name, @RequestParam String email) {
        clientService.register(new Client(name, email));
    }
}
