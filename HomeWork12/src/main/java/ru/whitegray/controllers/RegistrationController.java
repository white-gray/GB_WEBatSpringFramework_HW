package ru.whitegray.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.whitegray.dao.UserRepository;
import ru.whitegray.entity.Product;
import ru.whitegray.entity.User;
import ru.whitegray.service.SecurityService;
import ru.whitegray.service.UserService;
import ru.whitegray.validator.UserValidator;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }


    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userRepository.save(userForm);
        securityService.authoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "/";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Неверны логин или пароль");
        }
        if (logout != null) {
            model.addAttribute("message", "Вы успешно вышли");
        }
        return "login";
    }

}
