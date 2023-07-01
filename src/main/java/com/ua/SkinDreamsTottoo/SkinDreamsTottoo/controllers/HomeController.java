package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ClientService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.validatior.ClientValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")

public class HomeController {
    private final ClientService clientService;
    private final ClientValidator clientValidator;




    @Autowired
    public HomeController(ClientService clientService, ClientValidator clientValidator) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("client", new Client());
        return "main-page";
    }

    @PostMapping("/new-client")
    public String orderTattoo(@Valid @ModelAttribute("client")  Client client, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        clientValidator.validate(client, bindingResult);
        if (bindingResult.hasErrors()){
            return "main-page";
        }
        client.setRegistrationTime(LocalDateTime.now());
        clientService.saveClient(client);
        redirectAttributes.addFlashAttribute("successMessage", "ДЯКУЮ з Вами скоро зв'яжуться");
        return "redirect:/#success";
        //TODO everywhere

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
