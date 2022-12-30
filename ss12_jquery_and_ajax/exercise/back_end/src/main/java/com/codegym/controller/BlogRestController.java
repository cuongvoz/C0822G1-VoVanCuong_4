package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getList() {
        List<Category> list = iCategoryService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> getBlogList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> list = iBlogService.findALL(pageable);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> getBlogById(@PathVariable("id") int id) {
        List<Blog> list = iBlogService.findByCategory(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
//,@RequestBody Blog blog
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> searchBlog(@PathVariable("title") String title ) {
        if (title == null) {
            title = "";
        }
        List<Blog> list = iBlogService.searchBlog(title);
//        if (list.isEmpty()) {
//
//            return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
