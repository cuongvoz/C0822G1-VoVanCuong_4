package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @RequestMapping
    public String getHome(Model model) {
        model.addAttribute("list",iProductService.findAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String getToCart(@PathVariable("id") int id,Model model,@ModelAttribute("cart") Cart cart) {
        Product product = iProductService.findById(id);
        cart.addProduct(product);
        model.addAttribute("list",cart.getMap());
        model.addAttribute("cart",cart);
        return "/cart";
    }
    @GetMapping("/down/{id}")
    public String downValue(@PathVariable("id") int id,@ModelAttribute("cart") Cart cart,Model model) {
        Product product = iProductService.findById(id);
        if (!cart.checkItemInCart(product)) {
            return "/error";
        }
        cart.downValue(product);
        model.addAttribute("list",cart.getMap());
        model.addAttribute("cart",cart);
        return "/cart";
    }

}
