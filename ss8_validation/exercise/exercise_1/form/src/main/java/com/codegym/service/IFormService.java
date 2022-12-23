package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IFormService {
    void crateUser(User user);
    List<User> findAll();
}
