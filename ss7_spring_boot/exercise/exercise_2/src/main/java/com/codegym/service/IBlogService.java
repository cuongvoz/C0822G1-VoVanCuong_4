package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
     List<Blog> findAll();
     void add(Blog blog);
     Blog findById(int id);
     void delete(int id);
}
