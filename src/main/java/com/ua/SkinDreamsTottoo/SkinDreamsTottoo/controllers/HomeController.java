package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ClientService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")

public class HomeController {
    private final ClientService clientService;


    private final ReviewService reviewService;

    @Autowired
    public HomeController(ClientService clientService, ReviewService reviewService) {
        this.clientService = clientService;
        this.reviewService = reviewService;
    }

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("reviews", reviewService.findAllReview());
        return "/main-page";
    }

    @PostMapping("/new-client")
    public String orderTattoo(@ModelAttribute Client client){
        client.setRegistrationTime(LocalDateTime.now());
        clientService.saveClient(client);
        return "redirect:/";

    }

}
