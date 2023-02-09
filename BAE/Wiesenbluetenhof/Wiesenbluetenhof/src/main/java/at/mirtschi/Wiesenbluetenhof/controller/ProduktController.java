package at.mirtschi.Wiesenbluetenhof.controller;

import at.mirtschi.Wiesenbluetenhof.datamodel.Category;
import at.mirtschi.Wiesenbluetenhof.datamodel.Product;
import at.mirtschi.Wiesenbluetenhof.dto.ProductDTO;
import at.mirtschi.Wiesenbluetenhof.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProduktController {

    @Autowired //erstellt automatisch Repository
    private ProductRepository prodRepo;

    @PostMapping("/create")
    public Product createProduct(@RequestBody @Valid ProductDTO productDTO) {
        Product product = fromDTO(productDTO);
        prodRepo.save(product);
        return product;
    }

    // @Valid - Übernahme der Validierung v. DTO

    @PostMapping("/findBy/category/")
    public List<Product> findProductsByCategory(@RequestBody @Valid Category category) {
        return prodRepo.findProductsByCategory(category);
    }

    @PostMapping("/findBy/price/")
    public List<Product> findProductByPriceBefore(@RequestBody Integer price) {
        return prodRepo.findProductsByPriceBefore(price);
    }

    @GetMapping("/{id}")
    public Optional<Product> findProductByID(@PathVariable long id) {
        return prodRepo.findById(id);
    }
    @DeleteMapping ("/delete/{id}")
    public String deleteProduct (@PathVariable long id)
    {
        if(prodRepo.existsById(id)) {
            prodRepo.deleteById(id);
            return "Erfolg!";
        } else {
            return "Fehlschlag!";
        }

    }


    private Product fromDTO(ProductDTO productDTO) {
        return new Product(productDTO.getName(),productDTO.getDescription(),
                    productDTO.getPrice(),new Category(productDTO.getCategory(),""));
    }
}
