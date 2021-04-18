package ru.whitegray.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.whitegray.actions.ProductRepository;
import ru.whitegray.products.Product;

@Controller
@RequestMapping("/")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("ProductList")
        public String product_list(Model model) {
            model.addAttribute("products", productRepository.getProducts());
            return "product_list";
        }

    @GetMapping("ProductID{id}")
    public String product_id(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productRepository.getProduct(id));
        return "product_id";
    }
}
