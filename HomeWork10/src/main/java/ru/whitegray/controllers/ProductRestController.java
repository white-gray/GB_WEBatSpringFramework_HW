package ru.whitegray.controllers;

import ru.whitegray.entity.Cart;
import ru.whitegray.entity.Product;
import ru.whitegray.dao.ProductDao;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductRestController {
    private final ProductDao productDao;

    public ProductRestController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/all")
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productDao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping("/{name}/{price}/{quantiry}")
    public void product_add(@PathVariable(name = "name") String name, @PathVariable(value = "price") float price, @PathVariable(value = "quantiry") int quantiry) {
        Product prod = new Product(name, price, quantiry);
        productDao.saveAndFlush(prod);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productDao.deleteById(id);
    }
}
