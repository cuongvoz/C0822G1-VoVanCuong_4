package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailRegex {
    private static final String EMAIL = "^[\\w]+\\@[a-z]+\\.com$";

    @RequestMapping
    public String getHome() {
        return "/index";
    }



    @RequestMapping("/validate")
    public String check(Model model , @RequestParam("email") String email) {
        if (!email.matches(EMAIL)) {
            model.addAttribute("result", email + " không hợp lệ");
            return "/index";
        } else {
            model.addAttribute("result","xin chào " + email);
            return "/result";

        }
    }
}
