package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @Autowired
    IFormService formService;

    @RequestMapping
    public String getForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "/form";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("user") UserDto user, BindingResult bindingResult,Model model) {

        new UserDto().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/form";
        }
        User user1 =new User();
        BeanUtils.copyProperties(user,user1);
        this.formService.crateUser(user1);
        model.addAttribute("list",formService.findAll());
        return "/result";
    }
}
