package com.codegym.service;

import com.codegym.model.PayBook;

import java.util.List;

public interface IPayBookService {
    List<PayBook> findAll();

    PayBook findById(int id);

    void save(PayBook payBook);

    void remove(int id);
}
