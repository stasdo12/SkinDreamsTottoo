package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.MasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.MasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class MasterService {

    private final MasterRepository masterRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public MasterService(MasterRepository masterRepository, ModelMapper modelMapper) {
        this.masterRepository = masterRepository;
        this.modelMapper = modelMapper;
    }



    public List<Master> findAllMasters(){
        log.info("Found all the Masters");
        return masterRepository.findAll();
    }


    public Master findMasterById(long id){
        log.info("Found Master By Id");
        return masterRepository.findById(id).orElseThrow(()-> new SDException("Master not Found"));
    }


    @Transactional
    public Master saveMaster(Master master){
        log.info("Save Master");
        return masterRepository.save(master);
    }

    @Transactional
    public void deleteMasterById(long id){
        log.info("Delete Master");
        masterRepository.deleteById(id);
    }

    @Transactional
    public Master updateMaster(Master updatingMaster){
        log.info("Update Client");
        return masterRepository.save(updatingMaster);
    }




    public Master convertMasterDTOToMaster(MasterDTO masterDTO){
        return modelMapper.map(masterDTO, Master.class);
    }

    public MasterDTO convertMasterToMasterDTO(Master master){
        return modelMapper.map(master, MasterDTO.class);
    }
}
