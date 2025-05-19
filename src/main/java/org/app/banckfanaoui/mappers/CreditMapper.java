package org.app.banckfanaoui.mappers;

import org.app.banckfanaoui.dtos.CreditDTO;
import org.app.banckfanaoui.entites.Credit;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "remboursementIds", expression = "java(credit.getRemboursements() != null ? credit.getRemboursements().stream().map(r -> r.getId()).collect(Collectors.toList()) : null)")
    CreditDTO toDto(Credit credit);

    @Mapping(target = "client", ignore = true) // à gérer dans le service
    @Mapping(target = "remboursements", ignore = true)
    Credit toEntity(CreditDTO dto);
}
