package ru.whitegray.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ProductController {

    @GetMapping("index")
    public String list (ModelAndView modelAndView) {
        return "product_list";
    }
}
