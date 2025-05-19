package org.app.banckfanaoui.mappers;

import org.app.banckfanaoui.dtos.RemboursementDTO;
import org.app.banckfanaoui.entites.Remboursement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RemboursementMapper {

    @Mapping(target = "creditId", source = "credit.id")
    RemboursementDTO toDto(Remboursement remboursement);

    @Mapping(target = "credit", ignore = true) // à gérer dans service
    Remboursement toEntity(RemboursementDTO dto);
}

