package at.mirtschi.Wiesenbluetenhof.controller;

import at.mirtschi.Wiesenbluetenhof.datamodel.Category;
import at.mirtschi.Wiesenbluetenhof.datamodel.User;
import at.mirtschi.Wiesenbluetenhof.repository.CategoryRepository;
import at.mirtschi.Wiesenbluetenhof.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired //erstellt automatisch Repository
    private UserRepository userRepo;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }

    @GetMapping("/get")
    public List<User> getAllCategories () {
        return userRepo.findAll();
    }
}
