package com.codegym.controller;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("login",new Login());
        return "/home";
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = UserDao.checkUser(login);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user","user",user);
            return modelAndView;
        }
    }
}
