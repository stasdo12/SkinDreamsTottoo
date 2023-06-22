package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HomeController {


    private final ReviewService reviewService;

    @Autowired
    public HomeController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("reviews", reviewService.findAllReview());
        return "/main-page";
    }
}
