package artyom.springproject.controller;

import artyom.springproject.entity.Product;
import artyom.springproject.payload.NewProductPayload;
import artyom.springproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("list")
    public String listProducts(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String ProductAdd() {
        return "catalogue/products/newProduct";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {
        Product product = this.productService.createProduct(payload.title(), payload.details());
        return "redirect:%d".formatted(product.getId());
    }
}
