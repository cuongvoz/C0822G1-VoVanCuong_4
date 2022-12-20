package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    List<Product> findByName(String name,String description,double price);
    void create(Product product);
    Product findByID(int id);
    void delete(int id);
    void update(Product product);
}
