package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findALL(Pageable pageable);
    void save(Customer customer);
    Customer findById(int id);
    void delete(Customer customer);
    Page<Customer> findByAll(String name,String address,String type,Pageable pageable);
}
