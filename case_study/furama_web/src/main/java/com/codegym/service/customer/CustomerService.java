package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findALL(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void delete(Customer customer) {

         iCustomerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findByAll(String name, String address,String type, Pageable pageable) {
        return iCustomerRepository.findByAll(name,address,type,pageable);
    }
}
