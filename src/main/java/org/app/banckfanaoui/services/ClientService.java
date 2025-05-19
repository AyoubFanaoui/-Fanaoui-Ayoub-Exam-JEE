package org.app.banckfanaoui.services;

import org.app.banckfanaoui.dtos.ClientDTO;
import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.mappers.ClientMapper;
import org.app.banckfanaoui.respositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.toDTO(client);
    }

    public ClientDTO saveClient(ClientDTO dto) {
        Client client = ClientMapper.toEntity(dto);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.toDTO(savedClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
