package com.repository;

import com.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> findAll();
    Mail findById(int id);
    boolean update (Mail mail);
    String[] listLanguage();
    int[] listSize();
}
