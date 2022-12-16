package com.model;

public class Mail {
    private int id;
   private String language;
   private  int size;
   private boolean filter;
   private String signature;

    public Mail() {
    }

    public Mail(int id, String language, int size, boolean filter, String signature) {
        this.id = id;
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
