package at.mirtschi.Wiesenbluetenhof.controller;


import at.mirtschi.Wiesenbluetenhof.datamodel.User;
import at.mirtschi.Wiesenbluetenhof.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @DeleteMapping  ("/delete/{uid}")
    public String deleteUser (@PathVariable long uid) {
        if (userRepo.existsById(uid)) {
            userRepo.deleteById(uid);
            return "Erfolg!";
        } else {
            return "Fehlschlag!";
        }

    }

    @GetMapping("/{uid}")
    public Optional<User> findUsernameByID(@PathVariable long uid) {
        return userRepo.findById(uid);
    }
}
