package com.controller;

import com.model.Student;
import com.service.IStudentService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
     IStudentService studentService = new StudentService();
    @RequestMapping
    public String goHome(Model model){
        List<Student> list = this.studentService.findAll();
        model.addAttribute("list",list);
        model.addAttribute("isModal",true);
        model.addAttribute("student",new Student());
        return "/index";
    }


    @PostMapping("/delete")
    public String deleteStudent(Model model,int id) {
        String message = "xóa không thành công";
       boolean check = this.studentService.delete(id);
       if (check) {
           message = "xóa thành công";
       }
        List<Student> list = this.studentService.findAll();
        model.addAttribute("list",list);
        model.addAttribute("message",message);
        model.addAttribute("student",new Student());
        return "/index";
    }

    @GetMapping("/sort")
    public String sortList(Model model) {
        List<Student> list = this.studentService.sort();
        model.addAttribute("list",list);
        model.addAttribute("sort",true);

        model.addAttribute("student",new Student());
        return "/index";
    }

    @GetMapping("/reverse")
    public String reverseList(Model model) {
        List<Student> list = this.studentService.reverse();
        model.addAttribute("list",list);
        model.addAttribute("sort",false);
        model.addAttribute("student",new Student());
        return "/index";

    }

    @PostMapping("/edit")
    public String editStudent(Model model,@ModelAttribute("student") Student student) {
        boolean check = this.studentService.edit(student);
        String message = "Chỉnh sửa không thành công";
        if (check) {
            message = "Chỉnh sửa thành công";
        }
        List<Student> list = this.studentService.findAll();
        model.addAttribute("list",list);
        model.addAttribute("message",message);
        model.addAttribute("student",new Student());
        return "/index";

    }

    @PostMapping("/find")
    public String find(String name, Model model) {
        List<Student> list = this.studentService.search(name);
        model.addAttribute("list",list);
        model.addAttribute("student",new Student());
        return "/index";

    }

    @PostMapping("/add")
    public String addStudent(Model model, @ModelAttribute("student") Student student){
       boolean check = this.studentService.add(student);
        String message = "Thêm mới không thành công";
        if (check) {
            message = "thêm mới thành công";
        }
        List<Student> list = this.studentService.findAll();
        model.addAttribute("list",list);
        model.addAttribute("message",message);
        model.addAttribute("student",new Student());
        return "/index";
    }
}
