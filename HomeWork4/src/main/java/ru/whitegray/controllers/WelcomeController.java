package ru.whitegray.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.whitegray.actions.ProductRepository;


@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Sir");
        return "index";
    }

}