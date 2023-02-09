package at.mirtschi.Wiesenbluetenhof.controller;

import at.mirtschi.Wiesenbluetenhof.datamodel.Cart;
import at.mirtschi.Wiesenbluetenhof.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired //erstellt automatisch Repository
    private CartRepository cartRepo;

    @PostMapping("/create")
    public Cart createCart(@RequestBody Cart cart) {
        cartRepo.save(cart);
        return cart;
    }


    @GetMapping("/{cartid}")
    public Optional<Cart> findCartByID(@PathVariable long cartid) {
        return cartRepo.findById(cartid);
    }
}
