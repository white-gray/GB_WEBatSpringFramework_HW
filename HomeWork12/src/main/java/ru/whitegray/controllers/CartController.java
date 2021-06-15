package ru.whitegray.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.whitegray.dao.CartDao;
import ru.whitegray.dao.ProductDao;
import ru.whitegray.entity.Cart;
import ru.whitegray.entity.Product;

import java.util.Collections;
import java.util.Date;


@RequiredArgsConstructor
@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartDao cartDao;
    private final ProductDao productDao;


    @GetMapping({"", "/{pageId}"})
    public String list(Model model, @PathVariable(required = false) Integer pageId) {
        if (pageId == null) {
            pageId = 1;
        }
        PageRequest pageRequest = PageRequest.of(pageId - 1, 7);
        final Page<Cart> cart = cartDao.findAll(pageRequest);
        model.addAttribute("cartt", cart.getContent());
        final int pageNumber = cart.getPageable().getPageNumber();
        model.addAttribute("currentPage", pageNumber + 1);
        model.addAttribute("previousPage", cart.getPageable().hasPrevious() ? pageNumber : null);
        model.addAttribute("nextPage", cart.getTotalPages() > pageNumber + 1 ? pageNumber + 2 : null);
        model.addAttribute("date", new Date());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("cart", new Cart());
        return "cart";
    }




    @GetMapping("/remove/{id}")
    public String removeProductFromCart(@PathVariable Long id) {
        addToShop(id);
        return "redirect:/cart";
    }

    public void addToShop(Long productId) {
        for (Cart cartFind : cartDao.findAll())
            if (cartFind.getProduct_id() == productId) {
                if (cartFind.getQuantity()==0){
                    cartFind.setId(null);
                    return;
                }
                cartFind.setQuantity(cartFind.getQuantity() -1);
                productDao.getOne(productId).setQuantity(productDao.getOne(productId).getQuantity() + 1);
                cartDao.save(cartFind);
                return;
            }
    }

    @GetMapping("add/{id}")
    public String addProductToCart(@PathVariable Long id) {
        addToCart(id);
        return "redirect:/product";
    }

    public void addToCart(Long productId) {
        if (productDao.getOne(productId).getQuantity() > 0) {
            for (Cart cartFind : cartDao.findAll())
                if (cartFind.getProduct_id() == productId) {
                    cartFind.setQuantity(cartFind.getQuantity() + 1);
                    productDao.getOne(productId).setQuantity(productDao.getOne(productId).getQuantity() - 1);
                    cartDao.save(cartFind);
                    return;
                }
            Cart cart = new Cart ();
            cart.setProduct_id(productId);
            cart.setQuantity(1);
            productDao.getOne(productId).setQuantity(productDao.getOne(productId).getQuantity() - 1);
            cartDao.save(cart);
        }
    }

}
