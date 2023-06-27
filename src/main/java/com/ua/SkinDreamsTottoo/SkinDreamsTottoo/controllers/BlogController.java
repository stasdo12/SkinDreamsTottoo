package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nash-blog")
public class BlogController {


    @GetMapping
    public String blogPage(){
        return "blog/index";

        //TODO sql blog and service
    }
}
