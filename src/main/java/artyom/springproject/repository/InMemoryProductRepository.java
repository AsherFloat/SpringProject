package artyom.springproject.repository;

import artyom.springproject.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<>());

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(this.products.stream().max(Comparator.comparingInt(Product::getId))
                .map(Product::getId)
                .orElse(0) + 1);
        this.products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return this.products.stream().filter(product -> product.getId().equals(productId)).findFirst();
    }

    @Override
    public void deleteById(Integer id) {
        this.products.removeIf(product -> product.getId().equals(id));
    }
}
