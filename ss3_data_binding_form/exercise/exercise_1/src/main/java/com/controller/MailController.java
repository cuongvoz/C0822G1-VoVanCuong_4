package com.controller;

import com.model.Mail;
import com.service.IMailService;
import com.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MailController {
    IMailService iMailService = new MailService();

    @GetMapping
    public String getHome(Model model) {
        List<Mail> mailList = this.iMailService.findAll();
        model.addAttribute("list",mailList);
        return "/index";
    }
    @RequestMapping("/edit/{id}")
    public String update(@PathVariable int id,Model model){
        Mail mail = this.iMailService.findById(id);
        int[] listSize = this.iMailService.listSize();
        String[] listLanguage = this.iMailService.listLanguage();
        model.addAttribute("mail",mail);
        model.addAttribute("listSize",listSize);
        model.addAttribute("listLanguage",listLanguage);
        return "/update";
    }
    @PostMapping("/edit")
    public String UpdateMail(@ModelAttribute("mail") Mail mail,Model model){
        boolean success =  this.iMailService.update(mail);
        model.addAttribute("list",this.iMailService.findAll());
         String message = "sửa không thành công";
         if (success) {
             message = "chỉnh sửa thành công";
         }
         model.addAttribute("message",message);
        return "/index";
    }
}
