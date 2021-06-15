package ru.whitegray.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.whitegray.dao.CartDao;
import ru.whitegray.dao.ProductDao;
import ru.whitegray.entity.Cart;
import ru.whitegray.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductDao productDao;


    @GetMapping({"", "/{pageId}"})
    public String list(Model model, @PathVariable(required = false) Integer pageId) {
        if (pageId == null) {
            pageId = 1;
        }
        PageRequest pageRequest = PageRequest.of(pageId - 1, 7);
        final Page<Product> products = productDao.findAll(pageRequest);
        model.addAttribute("products", products.getContent());
        final int pageNumber = products.getPageable().getPageNumber();
        model.addAttribute("currentPage", pageNumber + 1);
        model.addAttribute("previousPage", products.getPageable().hasPrevious() ? pageNumber : null);
        model.addAttribute("nextPage", products.getTotalPages() > pageNumber + 1 ? pageNumber + 2 : null);
        model.addAttribute("date", new Date());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("product", new Product());
        model.addAttribute("cart", new Cart());
        return "products";
    }

    @GetMapping("delete/{id}")
    public String removeProduct(@PathVariable Long id) {
        productDao.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping("add")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productDao.saveAndFlush(product);
        return "redirect:/product";
    }
}
