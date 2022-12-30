package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;



    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findALL(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> searchBlog(String title) {
        return iBlogRepository.searchBlog(title);
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findByCategory(int id) {
        return iBlogRepository.findByCategory(id);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.delete(findById(id));
    }

    @Override
    public Page<Blog> selectByCategory(int id,Pageable pageable) {
        return iBlogRepository.selectByCategory(id,pageable);
    }


}
