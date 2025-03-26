package artyom.springproject.repository;

import artyom.springproject.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Product addProduct(Product product);

    Optional<Product> findById(Integer productId);
}
