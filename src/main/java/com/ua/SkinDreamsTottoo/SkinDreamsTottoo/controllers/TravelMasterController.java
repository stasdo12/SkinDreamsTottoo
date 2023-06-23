package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.TravelingMaster;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.TravelingMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
@RequestMapping("/guest-master")
public class TravelMasterController {

    private final TravelingMasterService travelingMasterService;


    @Autowired
    public TravelMasterController(TravelingMasterService travelingMasterService) {
        this.travelingMasterService = travelingMasterService;
    }


    @GetMapping
    public String gestMasterPage(Model model) {
        model.addAttribute("guestMasters", travelingMasterService.findAllTravelingMaster());
        return "travel-master/index";
    }


    @PostMapping("/new-guest-master")
    public String newGuest(@ModelAttribute TravelingMaster travelingMaster) {
        travelingMaster.setDesiredDates(List.of(LocalDate.of(1994, Month.APRIL, 12)));
        travelingMasterService.saveTravelingMaster(travelingMaster);
        return "redirect:/";
    }


}
