package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @RequestMapping("")
    public String translate(Model model, String english) {
        String[] arr1 = {"dog", "cat", "bird", "fish"};
        String[] arr2 = {"Chó", "mèo", "chim", "cá"};
        String[] arr3 = {"https://s.memehay.com/files/posts/20200816/1bf9900c6546496b7ac7366e9cbb5f8fcho-vang-do-mat-xau-ho.jpg","https://tiengdong.com/wp-content/uploads/www_tiengdong_com-meme-meo-dua-tay-che-mieng-khoc.jpg","https://i.pinimg.com/564x/37/3c/1d/373c1dffd8109754a70f971bac7e7f6a.jpg" ,"https://kenh14cdn.com/thumb_w/600/2016/160205lctrump1-1454652003575.jpg"};
        String link = "https://i.pinimg.com/736x/d6/5b/39/d65b39343367fb7be9638487c1888a13.jpg";
        String result = "Không tìm thấy";
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].equals(english)) {
                result = arr2[i];
                link = arr3[i];
                break;
            }
        }
        model.addAttribute("link",link);
        model.addAttribute("dich", result);
        return "/result";

    }
}
