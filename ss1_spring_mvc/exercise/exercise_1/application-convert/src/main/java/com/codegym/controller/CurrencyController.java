package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    @RequestMapping("")
    public String getResult(Model model, String value, String firstType,String secondType) {
        double money = Double.parseDouble(value);
        String result = null;
        if (firstType.equals("USD") && secondType.equals("VND")) {
            result = "Số tiền " + money + " USD đổi sang VND là : " + (money * 23000) + " VND";
        } else if (firstType.equals("VND") && secondType.equals("USD")) {
            result = "Số tiền " + money + " VND đổi sang USD là : " + (money / 23000) + " USD";
        } else {
            result = "Bạn đã quên chọn chọn mệnh giá cần đổi ";
        }
        model.addAttribute("result",result);
        return "/result";
    }

}
