package org.app.banckfanaoui.mappers;

import org.app.banckfanaoui.dtos.ClientDTO;
import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.entites.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.*;

import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());

        if (client.getCredits() != null) {
            List<Long> creditIds = client.getCredits().stream()
                    .map(Credit::getId)
                    .collect(Collectors.toList());
            dto.setCreditIds(creditIds);
        }
        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        // La gestion des crédits est à faire dans la couche service
        return client;
    }
}