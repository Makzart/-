package com.ontu.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index(Model model) {
        String game[] = {"","X","O",
                        "O","X","",
                        "","X","O"}; 
        for(int i = 0; i< game.length;i++)
        {
            model.addAttribute("var%s".formatted(i), game[i]);
        }
        return "index";
    }
}