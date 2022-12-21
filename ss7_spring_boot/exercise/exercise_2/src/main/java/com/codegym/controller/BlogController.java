package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @RequestMapping("")
    public String getHome(Model model) {
        model.addAttribute("list",iBlogService.findAll());
        model.addAttribute("blog",new Blog());
        return "/list";
    }

    @PostMapping("/delete")
    public String delete( int id){
        iBlogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addBlog(Blog blog){
        iBlogService.add(blog);
        return "redirect:/";
    }
}
