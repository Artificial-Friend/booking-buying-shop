package registration.booking.service.controller;

import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import registration.booking.service.model.Cart;
import registration.booking.service.model.Product;
import registration.booking.service.service.CartService;
import registration.booking.service.service.ProductService;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {
    private final ProductService productService;
    private final CartService cartService;

    @PatchMapping("/{cartId}/add-product")
    public ResponseEntity<Object> addProduct(@PathVariable Long cartId,
                                             @RequestParam String productName,
                           @RequestParam int quantity) {
        Product product = productService.findByName(productName);
        Cart cart = cartService.find(cartId);
        Map<Product, Integer> bookedProducts = cart.getBookedProducts();
        if (bookedProducts.containsKey(product)) {
            bookedProducts.put(product, bookedProducts.get(product) + quantity);
        } else {
            bookedProducts.put(product, quantity);
        }
        product.setQuantity(product.getQuantity() - quantity);
        productService.createOrUpdate(product);
        cartService.createOrUpdate(cart);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{cartId}/remove-product")
    public ResponseEntity<Object> removeProduct(@PathVariable Long cartId,
                                                @RequestParam String productName,
                                        @RequestParam(required = false) int quantity) {
        Product product = productService.findByName(productName);
        Cart cart = cartService.find(cartId);
        Map<Product, Integer> bookedProducts = cart.getBookedProducts();
        if (quantity == 0 || bookedProducts.get(product) <= quantity) {
            bookedProducts.remove(product);
        } else {
            bookedProducts.put(product, bookedProducts.get(product) - quantity);
        }
        product.setQuantity(product.getQuantity() + quantity);
        productService.createOrUpdate(product);
        cartService.createOrUpdate(cart);
        return ResponseEntity.ok().build();
    }
}
