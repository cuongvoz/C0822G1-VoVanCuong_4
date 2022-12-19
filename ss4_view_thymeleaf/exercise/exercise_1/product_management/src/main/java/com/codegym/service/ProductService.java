package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

   private static List<Product> list;
   static {
       list = new ArrayList<>();
       list.add(new Product(1,"Xe máy",2000,"Xe Cũ","Xe Hôn Đa"));
       list.add(new Product(2,"Xe Đạp",2000,"Xe Mới","Xe Hitachi"));
       list.add(new Product(3,"Xe Ô tô",2000,"Xe Cũ","Xe Ford"));
       list.add(new Product(4,"Xe Máy",2000,"Xe Cũ","Xe yamaha"));
       list.add(new Product(5,"Xe Ô Tô",2000,"Xe mới","Xe Toyota"));
   }



    @Override
    public List<Product> findAll() {
        return this.list;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listz = new ArrayList<>();
        for (int i = 0 ; i < list.size();i++) {
            if (list.get(i).getName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
                listz.add(list.get(i));
            }
        }
       return listz;
    }


    private int getIDAutoIncrement(){
        return list.get(list.size()-1).getId() + 1;
    };

    @Override
    public void create(Product product) {
       product.setId(getIDAutoIncrement());
       list.add(product);
    }

    @Override
    public Product findByID(int id) {
        for (Product z: list) {
            if (z.getId() == id) {
                return z;
            }
        }
        return null;
    }


    @Override
    public void delete(int id) {
       for (int i = 0 ; i< list.size();i++) {
           if (id == list.get(i).getId()) {
               list.remove(i);
               break;
           }
       }

    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < list.size(); i++) {
            if (product.getId() == list.get(i).getId()) {
                list.set(i,product);
            }
        }
    }
}
