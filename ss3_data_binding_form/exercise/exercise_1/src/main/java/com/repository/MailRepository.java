package com.repository;

import com.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailRepository implements IMailRepository {
    private static String[] languageList = {"English", "Vietnamese", "Japanese", "Chinese"};
    private static int[] sizeList = {5, 10, 15, 25, 50, 100};
    private static List<Mail> list = new ArrayList<>();
    static {
        list.add(new Mail(1,"Vietnamese",10,true,"Bình Dương"));
        list.add(new Mail(2,"English",15,false,"Ohio"));
        list.add(new Mail(3,"Japanese",5,false,"Saitama"));
        list.add(new Mail(4,"Chinese",100,false,"Bing Chiling"));
    }



    @Override
    public List<Mail> findAll() {
        return list;
    }

    @Override
    public Mail findById(int id) {
        for (Mail x: list) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    @Override
    public boolean update(Mail mail) {
        for (Mail x: list) {
            if (x.getId() == mail.getId()) {
                x.setLanguage(mail.getLanguage());
                x.setFilter(mail.isFilter());
                x.setSignature(mail.getSignature());
                x.setSize(mail.getSize());
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] listLanguage() {
        return this.languageList;
    }

    @Override
    public int[] listSize() {
        return this.sizeList;
    }
}
