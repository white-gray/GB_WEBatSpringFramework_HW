package ru.whitegray.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.whitegray.dao.CartDao;
import ru.whitegray.entity.Cart;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartRestController<productDao> {


    private  final CartDao cartDao;

    public CartRestController(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @GetMapping("/all")
    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    @GetMapping("/{id}")
    public Cart product_showId(@PathVariable("id") Long id) {
        return cartDao.findById(id).orElseThrow(IllegalArgumentException::new);
    }

//    @PostMapping("/{product_id}/{buyer_id}/{quantity}")
//    public void product_add(@PathVariable(name = "product_id") Long product_id, @PathVariable(value = "buyer_id") Long buyer_id, @PathVariable(value = "buyer_id") Long buyer_id)
//    {
//        Cart cart = new Cart(product_id, buyer_id, quantity);
//        cartDao.saveAndFlush(cart);
//    }

    @DeleteMapping("/delete/{id}")
    public void product_deleteId(@PathVariable("id") Long id) {
        cartDao.deleteById(id);
    }



}