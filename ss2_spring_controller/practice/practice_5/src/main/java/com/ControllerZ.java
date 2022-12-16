package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class ControllerZ {


    @RequestMapping
    public String getHome() {
        return "/index";
    }
    @PostMapping("/alo")
    public String getLoiChao(@RequestParam("chao") String chaoz, Model model) {
        Date date = new Date();
// Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();
// Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(chaoz);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
// Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(locale_time);
        // Chuyển dữ liệu va gửi qua view
        model.addAttribute("city", chaoz);
        model.addAttribute("date", date);
        return "/index";
    }


}
