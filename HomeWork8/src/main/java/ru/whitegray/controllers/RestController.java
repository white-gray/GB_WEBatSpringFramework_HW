package ru.whitegray.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.whitegray.dao.ProgectDao;
import ru.whitegray.dao.ProgectDaoImpl;
import ru.whitegray.entity.Product;

@Controller
@RequestMapping("/")
public class RestController {

    private ProgectDaoImpl productDaoImpl;
    private ProgectDao productDao;

    public RestController(ProgectDaoImpl productDaoImpl, ProgectDao progectDao) {
        this.productDaoImpl = productDaoImpl;
        this.productDao = productDao;
    }

    @GetMapping("app/products")
    public String product_list(Model model) {
        model.addAttribute("products", productDao.findAll());
        System.out.println("productDao.findAll() = "+ productDao.findAll());
        return "product_list";
    }

    @GetMapping("app/products/{id}")
    public String product_showId(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productDao.findById(id));
        return "product_id";
    }

    @PostMapping("app/products/{name}/{price}")
    public void product_add(@PathVariable(name = "name") String name, @PathVariable(value = "price") float price)
    {
        Product prod = new Product(name, price);
        productDao.saveAndFlush(prod);
    }

    @GetMapping("/app/products/delete/{id}")
    public void product_deleteId(Model model, @PathVariable("id") Long id) {
        productDao.deleteById(id);
    }
}
