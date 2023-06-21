package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.ClientDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }


    public List<Client> findAllClient(){
        log.info("Found all the Clients");
        return clientRepository.findAll();
    }

    public Client findClientById(long id){
        log.info("Found Client By Id");
        return clientRepository.findById(id).orElse(null);
        //TODO or else exception
    }



    @Transactional
    public Client saveClient(Client client){
        log.info("Save Client");
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClientById(long id){
        log.info("Delete Client");
        clientRepository.deleteById(id);
    }


    @Transactional
    public Client updateClient(Client updatingClient){
        log.info("Update Client");
        return clientRepository.save(updatingClient);
    }



    public Client convertClientDTOToClient(ClientDTO clientDTO){
        return modelMapper.map(clientDTO, Client.class);
    }

    public ClientDTO convertClientToClientDTO(Client client){
        return modelMapper.map(client, ClientDTO.class);
    }
}
