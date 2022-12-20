package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name, String description,double price) {
        return productRepository.findByName(name,description,price);
    }

    @Override
    public void create(Product product) {
       productRepository.create(product);
    }

    @Override
    public Product findByID(int id) {
        return productRepository.findByID(id);
    }

    @Override
    public void delete(int id) {
      productRepository.delete(id);
    }

    @Override
    public void update(Product product) {
      productRepository.update(product);
    }
}
