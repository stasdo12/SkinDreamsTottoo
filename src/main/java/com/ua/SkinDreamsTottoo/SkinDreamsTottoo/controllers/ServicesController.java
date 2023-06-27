package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/uslugi")
public class ServicesController {

    private final ClientService clientService;

    @Autowired
    public ServicesController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public String servicePage() {
        return "service/index";
    }


    @PostMapping("/question")
    public String orderQuestion(@ModelAttribute Client client) {
        client.setRegistrationTime(LocalDateTime.now());
        clientService.saveClient(client);
        return "redirect:/";
    }
}
