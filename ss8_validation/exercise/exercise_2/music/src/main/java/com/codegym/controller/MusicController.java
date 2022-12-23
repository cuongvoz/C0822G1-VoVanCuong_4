package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.model.MusicDTO;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    IMusicService musicService;

    @RequestMapping("")
    public String getHome(Model model) {

        model.addAttribute("list",this.musicService.findAll());
        model.addAttribute("music",new MusicDTO());
        return "/form";
    }
    @PostMapping("/add")
    public String addMusic(@Validated @ModelAttribute("music") MusicDTO music, BindingResult bindingResult, Model model,String modal) {
        new MusicDTO().validate(music,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("isModal",modal);
            model.addAttribute("list",this.musicService.findAll());
            model.addAttribute("music",new MusicDTO());
            return "/form";
        }
        Music music1 = new Music();
        BeanUtils.copyProperties(music,music1);
        musicService.save(music1);
        return "redirect:/";
    }
}
