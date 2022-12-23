package com.codegym.service;

import com.codegym.model.User;
import com.codegym.repository.IFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService implements IFormService {

    @Autowired
    IFormRepository iFormRepository;

    @Override
    public void crateUser(User user) {
        iFormRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return iFormRepository.findAll();
    }
}
