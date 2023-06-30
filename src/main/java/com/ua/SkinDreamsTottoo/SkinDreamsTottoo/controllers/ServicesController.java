package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String orderQuestion(@ModelAttribute Client client, RedirectAttributes redirectAttributes) {
        client.setRegistrationTime(LocalDateTime.now());
        clientService.saveClient(client);
        redirectAttributes.addFlashAttribute("successMessage","ДЯКУЮ з Вами скоро зв'яжуться");
        return "redirect:/uslugi#success";
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
