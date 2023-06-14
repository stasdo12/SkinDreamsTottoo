package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.ClientDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }


    public Client convertClientDTOToClient(ClientDTO clientDTO){
        return modelMapper.map(clientDTO, Client.class);
    }

    public ClientDTO convertClientToClientDTO(Client client){
        return modelMapper.map(client, ClientDTO.class);
    }
}
