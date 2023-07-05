package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.TravelingMasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.TravelingMaster;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.EmailSenderService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.TravelingMasterService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.TravelingMasterValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/guest-master")
public class TravelMasterController {

    private final TravelingMasterService travelingMasterService;
    private final EmailSenderService emailSenderService;
    private final TravelingMasterValidator travelingMasterValidator;


    @Autowired
    public TravelMasterController(TravelingMasterService travelingMasterService, EmailSenderService emailSenderService, TravelingMasterValidator travelingMasterValidator) {
        this.travelingMasterService = travelingMasterService;
        this.emailSenderService = emailSenderService;
        this.travelingMasterValidator = travelingMasterValidator;
    }


    @GetMapping
    public String gestMasterPage(
            //TODO make page from 1
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("travelMaster", new TravelingMaster());
        model.addAttribute("guestMasters", travelingMasterService.findAllTravelingMaster(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "travel-master/index";
    }


    @PostMapping("/new-guest-master")
    public String newGuest(@Valid @ModelAttribute TravelingMasterDTO travelingMasterDTO, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        //add handleReviewFormErrors
        travelingMasterValidator.validate(travelingMasterDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "travel-master/index";
        }
        //Sending email from client
        String toEmail = "stanislavdonetc@gmail.com";
        emailSenderService.sendEmail(toEmail, "Travel Master", "Travel Master names: " +
                travelingMasterDTO.getName() +"\n" + "Travel Master phone: " +
                travelingMasterDTO.getPhone() +"\n" +"Travel Master email: " +
                travelingMasterDTO.getEmail() + "\n" + "Travel Master social media: "  +
                travelingMasterDTO.getSocialMedia() + "\n" + "Travel Master description: "+
                travelingMasterDTO.getDescription());
        travelingMasterService.saveTravelingMaster(travelingMasterService.convertTravelingMasterDTOToTravelingMaster(travelingMasterDTO));
        redirectAttributes.addFlashAttribute("successMessage","ДЯКУЮ з Вами скоро зв'яжуться");
        return "redirect:/guest-master#success";
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
