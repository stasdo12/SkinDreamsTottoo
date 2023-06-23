package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uslugi")
public class ServicesController {


    @GetMapping
    public String servicePage(){
        return "service/index";
    }
}
