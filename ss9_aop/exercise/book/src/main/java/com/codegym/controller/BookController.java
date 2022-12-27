package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.PayBook;
import com.codegym.service.IBookService;
import com.codegym.service.IPayBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    IPayBookService iPayBookService;

    @RequestMapping
    public String getHome(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "/home";
    }

    @PostMapping("/borrow")
    public String returnBorrow(int code,RedirectAttributes redirectAttributes){
        List<PayBook> list = iPayBookService.findAll();
        for (int i = 0; i < list.size();i++) {
            if (code == list.get(i).getCode()) {
               Book book = bookService.findById(list.get(i).getBook().getId()) ;
               iPayBookService.remove(list.get(i).getId());
               book.setQuantity(book.getQuantity() +1);
               bookService.save(book);
               redirectAttributes.addFlashAttribute("mess","Bạn đã trả sách " + book.getName());
                return "redirect:/";
            }
        }
        return "/errorPage";
    }

    @GetMapping("/borrow")
    public String borrow( int id, RedirectAttributes redirectAttributes) {
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        Book book = bookService.findById(id);
        if (book.getQuantity() == 0) {
            return "/errorPage";
        }
        book.setQuantity(book.getQuantity() -1);
        PayBook payBook = new PayBook(code,book);
        iPayBookService.save(payBook);
        redirectAttributes.addFlashAttribute("code",code);
        redirectAttributes.addFlashAttribute("check",true);
        bookService.save(book);
        return "redirect:/";
    }
}
