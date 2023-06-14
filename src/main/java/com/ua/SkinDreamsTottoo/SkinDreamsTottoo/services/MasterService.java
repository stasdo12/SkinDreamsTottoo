package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.MasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.MasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService {

    private final MasterRepository masterRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public MasterService(MasterRepository masterRepository, ModelMapper modelMapper) {
        this.masterRepository = masterRepository;
        this.modelMapper = modelMapper;
    }


    public Master convertMasterDTOToMaster(MasterDTO masterDTO){
        return modelMapper.map(masterDTO, Master.class);
    }

    public MasterDTO convertMasterToMasterDTO(Master master){
        return modelMapper.map(master, MasterDTO.class);
    }
}
