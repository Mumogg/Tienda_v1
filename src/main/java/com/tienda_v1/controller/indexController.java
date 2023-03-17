package com.tienda_v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {
    
    @GetMapping("/")
    public String inicio(Model model){ 
        return "index";
    }
    
}
