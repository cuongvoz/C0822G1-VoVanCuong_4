package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
   IProductService productService = new ProductService();

    @RequestMapping
    public String getHome(Model model) {
        model.addAttribute("list",this.productService.findAll());
        model.addAttribute("product",new Product());
        model.addAttribute("criteria", new SearchCriteria());
        return "/list";
    }

    @PostMapping("/delete")
    public String remove(int id,RedirectAttributes redirectAttributes){
        this.productService.delete(id);

        return "redirect:/";
    }

    @PostMapping("/add")
    public String addProduct(Product product, RedirectAttributes redirectAttributes) {
        this.productService.create(product);
        return "redirect:/";
    }

    @PostMapping("/find")
    public String find(Model model, String name,String description,String price){
        if (price == null || price == "") {
            price = "0";
        }
        model.addAttribute("list",this.productService.findByName(name,description,Double.parseDouble(price)));
        model.addAttribute("product",new Product());
        return "/list";
    }

    @PostMapping("/edit")
    public String edit(Product product,RedirectAttributes redirectAttributes){
        this.productService.update(product);
        return "redirect:/";
    }







}
