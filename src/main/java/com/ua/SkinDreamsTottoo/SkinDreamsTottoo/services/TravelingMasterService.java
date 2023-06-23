package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;


import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.TravelingMasterDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.TravelingMaster;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.TravelingMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TravelingMasterService {

    private final ModelMapper modelMapper;
    private final TravelingMasterRepository travelingMasterRepository;


    @Autowired
    public TravelingMasterService(ModelMapper modelMapper, TravelingMasterRepository travelingMasterRepository) {
        this.modelMapper = modelMapper;
        this.travelingMasterRepository = travelingMasterRepository;
    }


    public List<TravelingMaster> findAllTravelingMaster(){
        log.info("Found all the traveling masters");
        return travelingMasterRepository.findAll();
    }

    public TravelingMaster findTravelingMasterById(long id){
        log.info("Found Traveling Master By Id");
        return travelingMasterRepository.findById(id).orElse(null);
        //TODO or else exception
    }

    @Transactional
    public void saveTravelingMaster(TravelingMaster travelingMaster){
        log.info("Save TravelingMaster");
        travelingMasterRepository.save(travelingMaster);
    }


    @Transactional
    public void deleteTravelingMasterById(long id){
        log.info("Delete Traveling Master");
        travelingMasterRepository.deleteById(id);
    }


    @Transactional
    public TravelingMaster updateTravelingMaster(TravelingMaster updatingTravelingMaster){
        log.info("Update TravelingMaster");
        return travelingMasterRepository.save(updatingTravelingMaster);
    }




    public TravelingMaster TravelingMasterDTOToTravelingMaster(TravelingMasterDTO travelingMasterDTO){
        return modelMapper.map(travelingMasterDTO, TravelingMaster.class);
    }

    public TravelingMasterDTO convertTravelingMasterToTravelingMasterDTO(TravelingMaster travelingMaster){
        return modelMapper.map(travelingMaster, TravelingMasterDTO.class);
    }





}
