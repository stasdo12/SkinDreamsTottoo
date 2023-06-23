package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stili-tattoo")
public class TattooStyleController {


    @GetMapping
    public String stylePage (){
        return "tattoo-style/index";
    }
}
