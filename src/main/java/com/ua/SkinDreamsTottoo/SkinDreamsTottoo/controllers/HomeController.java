package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ClientService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.EmailSenderService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.ClientValidator;
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

    private final EmailSenderService emailSenderService;




    @Autowired
    public HomeController(ClientService clientService, ClientValidator clientValidator, EmailSenderService emailSenderService) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
        this.emailSenderService = emailSenderService;
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
        //Sending email from client
        String toEmail = "stanislavdonetc@gmail.com";
        emailSenderService.sendEmail(toEmail, "Client orders consultation", "Client names: " +
                client.getName() +"\n" + "Client phone: " +
                client.getPhone() +"\n" +"Client email: " +
                client.getEmail());
        redirectAttributes.addFlashAttribute("successMessage", "ДЯКУЮ з Вами скоро зв'яжуться");
        return "redirect:/#success";

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
