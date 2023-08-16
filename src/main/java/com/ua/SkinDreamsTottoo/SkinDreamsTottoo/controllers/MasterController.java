package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.MasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tattoo-masters")
public class MasterController {


    private final MasterService masterService;


    @Autowired
    public MasterController(MasterService masterService) {
        this.masterService = masterService;

    }

    @GetMapping
    public String allMasters(Model model){
        model.addAttribute("masters", masterService.findAllMasters());
        return "/masters/index";
    }

    @GetMapping("/{id}")
    public String showMaster(@PathVariable("id") long id, Model model){
        Master master = masterService.findMasterById(id);
        MasterDTO masterDTO = masterService.convertMasterToMasterDTO(master);
        model.addAttribute("master", masterDTO);
        model.addAttribute("imageURL", masterDTO.getImageURL());
        return "/masters/show-master-info";
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
