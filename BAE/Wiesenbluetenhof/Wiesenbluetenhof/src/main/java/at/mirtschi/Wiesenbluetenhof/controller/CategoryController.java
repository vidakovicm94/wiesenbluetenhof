package at.mirtschi.Wiesenbluetenhof.controller;

import at.mirtschi.Wiesenbluetenhof.datamodel.Category;
import at.mirtschi.Wiesenbluetenhof.datamodel.Product;
import at.mirtschi.Wiesenbluetenhof.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired //erstellt automatisch Repository
    private CategoryRepository categRepo;

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        categRepo.save(category);
        return category;
    }

    @GetMapping ("/get")
    public List<Category> getAllCategories() {
        return categRepo.findAll();
    }

    @GetMapping("/{cid}")
    public Optional<Category> findCategoryByID(@PathVariable long cid) {
        return categRepo.findById(cid);
    }
    @DeleteMapping ("/delete/{cid}")
    public String deleteCategory (@PathVariable long cid)
    {
        if(categRepo.existsById(cid)) {
            categRepo.deleteById(cid);
            return "Erfolg!";
        } else {
            return "Fehlschlag!";
        }

    }

}
