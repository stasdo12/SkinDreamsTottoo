package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.TravelingMasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.TravelingMaster;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.TravelingMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String gestMasterPage(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("guestMasters", travelingMasterService.findAllTravelingMaster(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "travel-master/index";
    }


    @PostMapping("/new-guest-master")
    public String newGuest(@ModelAttribute TravelingMasterDTO travelingMasterDTO) {
        travelingMasterService.saveTravelingMaster(travelingMasterService.convertTravelingMasterDTOToTravelingMaster(travelingMasterDTO));
        return "redirect:/";
    }


}
