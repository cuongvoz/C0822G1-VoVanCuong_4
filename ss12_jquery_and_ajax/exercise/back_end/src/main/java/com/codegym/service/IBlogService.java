package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
     Page<Blog> findAll(Pageable pageable);
     Page<Blog> findALL(Pageable pageable);
     List<Blog> searchBlog(String title);
     void add(Blog blog);
     Blog findById(int id);
     List<Blog> findByCategory(int id);
     void delete(int id);
     Page<Blog> selectByCategory(@Param("id") int id,Pageable pageable);
}
