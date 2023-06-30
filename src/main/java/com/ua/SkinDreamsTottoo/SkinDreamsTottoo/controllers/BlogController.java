package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nash-blog")
public class BlogController {

    private final BlogService blogService;


    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping
    public String blogPage(Model model) {
        model.addAttribute("blogs",blogService.findAllBlogs());
        return "blog/index";
    }

    @ExceptionHandler(SDException.class)
    public String handleClientException(SDException ex, Model model){
        model.addAttribute("errorMassage", ex.getMessage());
        return "templates/error/error-page";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "templates/error/error-page";
    }

}
