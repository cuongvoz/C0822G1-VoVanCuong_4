package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void add(Category category);
    Category findById(int id);

    void delete(int id);
}
