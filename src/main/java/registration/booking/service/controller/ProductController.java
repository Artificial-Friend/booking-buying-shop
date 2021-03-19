package registration.booking.service.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import registration.booking.service.model.Product;
import registration.booking.service.service.ProductService;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Product getByName(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping("/ordered/by-popular")
    public List<Product> getPopular() {
        return productService.findAllOrderedByPopularity();
    }

    @GetMapping("/ordered/by-cheapest")
    public List<Product> getCheapest() {
        return productService.findAllOrderedByCheapest();
    }

    @GetMapping("/ordered/by-most-expensive")
    public List<Product> getMostExpensive() {
        return productService.findAllOrderedByMostExpensive();
    }
}
