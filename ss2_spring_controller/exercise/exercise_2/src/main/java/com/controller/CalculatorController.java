package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @GetMapping
    public String getCalculator() {
        return "/index";
    }

    @RequestMapping("/calculate")
    public String calculator(double first, double second, String operator, Model model) {
        String result = null;
        switch (operator) {
            case "+":
                result = "Kết quả của " + first + " + " + second + " = "  + (first + second);
                break;
            case "-":
                result = "Kết quả của " + first + " - " + second + " = "  + (first - second);
                break;
            case "x":
                result = "Kết quả của " + first + " x " + second + " = "  + (first * second);
                break;
            case "/":
                if (second == 0) {
                    result = "Lỗi chia cho 0";
                } else {
                    result = "Kết quả của " + first + " / " + second + " = " + (first / second);
                }
                break;
        }
        model.addAttribute("result", result);
        return "/index";
    }

}
