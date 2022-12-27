package com.codegym.service;

import com.codegym.model.PayBook;
import com.codegym.repository.IBookPayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PayBookService implements IPayBookService{
    @Autowired
    IBookPayRepository iBookPayRepository;

    @Override
    public List<PayBook> findAll() {
        return iBookPayRepository.findAll();
    }

    @Override
    public PayBook findById(int id) {
        return iBookPayRepository.findById(id).get();
    }

    @Override
    public void save(PayBook payBook) {
        iBookPayRepository.save(payBook);
    }

    @Override
    public void remove(int id) {
     iBookPayRepository.deleteById(id);
    }

}
