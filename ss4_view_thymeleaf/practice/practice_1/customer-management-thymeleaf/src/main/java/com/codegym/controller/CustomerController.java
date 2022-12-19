package com.codegym.controller;


import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    private final ICustomerService iCustomerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }
    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/edit";
    }

    @PostMapping("/customer/delete")
    public String delete(Customer customer,Model model) {
        iCustomerService.remove(customer.getId());
        model.addAttribute("success", "Removed customer successfully!");
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/view";
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/delete";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer,Model model) {
        iCustomerService.update(customer.getId(), customer);
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer,Model model) {
        customer.setId((int) (Math.random() * 10000));
        iCustomerService.save(customer);
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "/index";
    }
}
