package artyom.springproject.repository;

import artyom.springproject.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
