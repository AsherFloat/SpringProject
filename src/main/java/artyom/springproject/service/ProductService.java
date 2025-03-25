package artyom.springproject.service;

import artyom.springproject.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
}
