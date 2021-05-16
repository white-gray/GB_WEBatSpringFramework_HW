package ru.whitegray.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.whitegray.dao.CartDao;
import ru.whitegray.dao.ProductDao;
import ru.whitegray.entity.Buyer;
import ru.whitegray.entity.Cart;
import ru.whitegray.entity.Product;

import java.util.Date;

@Controller
@RequestMapping("cart")
public class CartController {
    private final CartDao cartDao;

    public CartController(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @GetMapping("delete/{id}")
    public String removeProduct(@PathVariable Long id) {
        cartDao.deleteById(id);
        return "redirect:/product";
    }

//    @PostMapping("add/{id}")
//    public String saveProduct(@ModelAttribute("buyer") Buyer buyer, @ModelAttribute("product") Product product, @PathVariable Long id) {
//        cartDao.save(buyer, product, cartDao.getOne(id).getQuantity()+1);
//        return "redirect:/product";
//    }
}
