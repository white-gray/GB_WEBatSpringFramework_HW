package ru.whitegray.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.whitegray.dao.ProductDao;
import ru.whitegray.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController<productDao> {


    private  final ProductDao productDao;

    public ProductRestController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/all")
    public List<Product> findAll() {
        return productDao.findAll();
    }


    @GetMapping("/{id}")
    public Product product_showId(@PathVariable("id") Long id) {
        return productDao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping("/{name}/{price}")
    public void product_add(@PathVariable(name = "name") String name, @PathVariable(value = "price") float price)
    {
        Product prod = new Product(name, price);
        productDao.saveAndFlush(prod);
    }

    @DeleteMapping("/delete/{id}")
    public void product_deleteId(@PathVariable("id") Long id) {
        productDao.deleteById(id);
    }



}