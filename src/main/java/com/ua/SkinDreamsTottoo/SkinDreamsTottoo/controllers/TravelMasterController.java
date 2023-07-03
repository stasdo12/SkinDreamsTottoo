package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.TravelingMasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.TravelingMaster;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.TravelingMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/guest-master")
public class TravelMasterController {

    private final TravelingMasterService travelingMasterService;


    @Autowired
    public TravelMasterController(TravelingMasterService travelingMasterService) {
        this.travelingMasterService = travelingMasterService;
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
    public String newGuest(@ModelAttribute TravelingMasterDTO travelingMasterDTO, RedirectAttributes redirectAttributes) {
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
