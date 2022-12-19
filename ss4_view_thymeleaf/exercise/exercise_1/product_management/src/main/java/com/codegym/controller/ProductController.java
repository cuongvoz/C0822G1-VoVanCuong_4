package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
   IProductService productService = new ProductService();

    @RequestMapping
    public String getHome(Model model) {
        model.addAttribute("list",this.productService.findAll());
        return "/list";
    }

    @GetMapping("/delete/{id}")
    public String remove(Model model, @PathVariable("id") int id){
        this.productService.delete(id);
        model.addAttribute("list",this.productService.findAll());
        return "/list";
    }

    @PostMapping("/add")
    public String addProduct(Product product,Model model) {
        this.productService.create(product);
        model.addAttribute("list",this.productService.findAll());
        return "/list";
    }

    @PostMapping("/find")
    public String find(Model model,String name){
        model.addAttribute("list",this.productService.findByName(name));
        model.addAttribute("nameFind","không tìm thấy " + name);
        return "/list";
    }

    @PostMapping("/edit")
    public String edit(Model model,Product product){
        this.productService.update(product);
        model.addAttribute("list",this.productService.findAll());
        return "/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model,@PathVariable("id") int id) {
        model.addAttribute("product",this.productService.findByID(id));
        return "/edit";
    }

    @GetMapping("/create")
    public String showFormAdd(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @GetMapping("/view/{id}")
    public String viewDetal(Model model,@PathVariable("id") int id) {

        model.addAttribute("product",this.productService.findByID(id));
        return "/viewDetail";
    }

}
