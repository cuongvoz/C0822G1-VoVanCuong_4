package com.codegym.controller;


import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {



    @GetMapping("/")
    public String showForm(Model model){
       model.addAttribute("employee",new Employee());
      return "/employee/formAdd";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee,Model model) {
        model.addAttribute("id",employee.getId());
        model.addAttribute("name",employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        return "/employee/info";
    }
}
