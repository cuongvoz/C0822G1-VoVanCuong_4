package com.service;

import com.model.Mail;
import com.repository.IMailRepository;
import com.repository.MailRepository;

import java.util.List;

public class MailService  implements IMailService{
    IMailRepository mailRepository = new MailRepository();

    @Override
    public List<Mail> findAll() {
        return this.mailRepository.findAll();
    }

    @Override
    public Mail findById(int id) {
        return this.mailRepository.findById(id);
    }

    @Override
    public boolean update(Mail mail) {
     return   this.mailRepository.update(mail);
    }

    @Override
    public String[] listLanguage() {
        return this.mailRepository.listLanguage();
    }

    @Override
    public int[] listSize() {
        return this.mailRepository.listSize();
    }
}
