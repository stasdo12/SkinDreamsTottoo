package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
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




    @Autowired
    public HomeController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String mainPage(Model model){
        return "/main-page";
    }

    @PostMapping("/new-client")
    public String orderTattoo(@ModelAttribute Client client){
        client.setRegistrationTime(LocalDateTime.now());
        clientService.saveClient(client);
        return "redirect:/";

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
