package oop.tutorial.week6;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductSerivce productService;

    @PostMapping
    public Product addProduct(@RequestBody DigitalProduct product) { // temporary fix: concrete subclass for abstract Product
        System.out.println("addProduct called");
        return productService.addProduct(product);
    }

    @GetMapping("/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }

    @GetMapping
    public List<Product> getProducts() {
        System.out.println("getProducts called");
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        System.out.println("getProductById called");
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        System.out.println("deleteProduct called");
        productService.deleteProduct(id);
    }
}
