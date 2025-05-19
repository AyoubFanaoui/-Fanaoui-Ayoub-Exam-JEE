package org.app.banckfanaoui.services;

import org.app.banckfanaoui.dtos.ClientDTO;
import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.mappers.ClientMapper;
import org.app.banckfanaoui.respositories.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDTO createClient(ClientDTO dto) {
        Client client = clientMapper.toEntity(dto);
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    public ClientDTO getClient(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    // ajouter d'autres méthodes métier si nécessaire
}
