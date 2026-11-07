
package oop.tutorial.week6;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSerivce {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // Constructor - add initial products
    public ProductSerivce() {

        products.add(new DigitalProduct(
                nextId++,
                "Clean Code (E-book)",
                29.99,
                "/downloads/clean-code.pdf",
                4.2
        ));

        products.add(new PhysicalProduct(
                nextId++,
                "27-inch Monitor",
                249.99,
                5.4,
                "61cm x 41cm x 18cm"
        ));
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().contains(name))
                .toList();
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : products) {
            summaries.add(p.getSummary());
        }
        return summaries;
    }

    public void testDiscount(){
        DigitalProduct digital = new DigitalProduct(
                1L, "Java E-book", 100.00,
                "https://example.com/java", 25.5
        );

        PhysicalProduct physical = new PhysicalProduct(
                2L, "Laptop", 100.00,
                2.1, "35 x 25 x 2 cm"
        );

        digital.applyDiscount(0.30);
        physical.applyDiscount(0.50);

        System.out.println("Digital prouduct: "+digital.getDiscountedPrice());
        System.out.println("Physical prouduct: "+physical.getDiscountedPrice());
    }
}
