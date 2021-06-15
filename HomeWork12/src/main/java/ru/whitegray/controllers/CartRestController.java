package ru.whitegray.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.whitegray.dao.CartDao;
import ru.whitegray.entity.Cart;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/cart")
public class CartRestController<productDao> {


    private  final CartDao cartDao;


    @GetMapping("/all")
    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    @GetMapping("/{id}")
    public Cart product_showId(@PathVariable("id") Long id) {
        return cartDao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @DeleteMapping("/delete/{id}")
    public void product_deleteId(@PathVariable("id") Long id) {
        cartDao.deleteById(id);
    }



}