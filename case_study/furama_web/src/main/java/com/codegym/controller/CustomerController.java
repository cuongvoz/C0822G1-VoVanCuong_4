package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService service;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @RequestMapping
    public String showList(Model model, @PageableDefault(value =  5)Pageable pageable) {
        model.addAttribute("customer",new Customer());
        model.addAttribute("list",this.service.findALL(pageable));
        model.addAttribute("listType",this.iCustomerTypeService.findAll());
        return "view/customer/list";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        service.save(customer);
        return "redirect:/customer";
    }
    @PostMapping("/delete")
    public String deleteCustomer(int id) {
        service.delete(service.findById(id));
        return "redirect:/customer";
    }
    @GetMapping("/find")
    public String findByThree(String name,String address,String type,@PageableDefault(value =  5)Pageable pageable,Model model) {
        model.addAttribute("customer",new Customer());
        model.addAttribute("list",this.service.findByAll(name,address,type,pageable));
        model.addAttribute("listType",this.iCustomerTypeService.findAll());
        return "view/customer/list";
    }
}
