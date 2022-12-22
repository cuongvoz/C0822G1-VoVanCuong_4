package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;

    @RequestMapping("")
    public String getHome(Model model, String id, @PageableDefault(size = 5)Pageable pageable) {
        if (id == null || id == "1" || id == "" || Integer.parseInt(id) == 1) {
            model.addAttribute("list",iBlogService.findAll(pageable));
            model.addAttribute("valueSelect",1);
        } else {
            model.addAttribute("list",iBlogService.selectByCategory(Integer.parseInt(id),pageable));
            model.addAttribute("valueSelect",id);
        }

        model.addAttribute("categoryList",iCategoryService.findAll());
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",new Category());
        return "/list";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(int id){
        iCategoryService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category){
       iCategoryService.add(category);
        return "redirect:/";
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
