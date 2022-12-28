package com.codegym.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> productMap = new HashMap<>();

    public Map<Product, Integer> getMap() {
        return productMap;
    }

    public boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectProduct(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void downValue(Product product) {
        Map.Entry<Product,Integer> entry = selectProduct(product);
        if (entry.getValue() == 1) {
            productMap.remove(entry.getKey());
        } else {
            Integer value = entry.getValue() - 1;
            productMap.replace(entry.getKey(),value);
        }
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            productMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> entry = selectProduct(product);
            Integer value = entry.getValue() + 1;
            productMap.replace(entry.getKey(), value);
        }
    }

    public Integer countProductQuantity() {
        Integer countQuantity = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            countQuantity += entry.getValue();
        }
        return countQuantity;
    }

    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product,Integer> entry: productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
