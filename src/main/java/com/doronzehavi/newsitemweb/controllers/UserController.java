package com.doronzehavi.newsitemweb.controllers;

import com.doronzehavi.newsitemweb.model.user.User;
import com.doronzehavi.newsitemweb.service.SecurityService;
import com.doronzehavi.newsitemweb.service.UserService;
import com.doronzehavi.newsitemweb.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request, Model model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        securityService.autologin(user, request);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String error, String logout, Model model, Principal principal) {
        if (principal != null){
            return "redirect:/feed";
        }
        if (error != null) {
            model.addAttribute("error", "Your username or password are invalid.");
        }

        return "login";
    }

}
