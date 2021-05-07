package ru.whitegray.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.whitegray.dao.ProductDao;
import ru.whitegray.entity.Product;
import ru.whitegray.service.ProductsService;

@Controller
public class ProductController {

    private ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = (ProductDao) productDao;
    }

    @GetMapping("/app/products")
    public String product_list(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "product_list";
    }

//    @PostMapping("/app/products")
//    public String addProduct(Model model) {
//        productDao.save();
//        return "product_list";
//    }

    @GetMapping("/app/products/{id}")
    public String showProduct_id(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productDao.findById(id));
        return "product_id";
    }

    @GetMapping("/app/products/delete/{id}")
    public String deleteProduct_id(Model model, @PathVariable("id") Long id) {
        productDao.deleteById(id);
        return "redirect:product_list";
    }
}
