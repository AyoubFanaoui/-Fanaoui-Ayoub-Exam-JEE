package org.app.banckfanaoui.mappers;

import org.app.banckfanaoui.entites.Client;
import org.app.banckfanaoui.dtos.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "creditIds", expression = "java(client.getCredits() != null ? client.getCredits().stream().map(c -> c.getId()).collect(Collectors.toList()) : null)")
    ClientDTO toDto(Client client);

    @Mapping(target = "credits", ignore = true) // éviter récursion infinie
    Client toEntity(ClientDTO dto);
}
