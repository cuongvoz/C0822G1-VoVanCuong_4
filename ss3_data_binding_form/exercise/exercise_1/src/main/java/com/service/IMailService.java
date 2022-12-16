package com.service;

import com.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> findAll();
    Mail findById(int id);
    boolean update (Mail mail);
    String[] listLanguage();
    int[] listSize();
}
