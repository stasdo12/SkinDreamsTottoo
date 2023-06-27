package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.MasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
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
        return "/masters/show-master-info";
    }




}
