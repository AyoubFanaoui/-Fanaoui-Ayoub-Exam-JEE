package org.app.banckfanaoui.mappers;

import org.app.banckfanaoui.dtos.RemboursementDTO;
import org.app.banckfanaoui.entites.Remboursement;


public class RemboursementMapper {

    public static RemboursementDTO toDTO(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());

        if (remboursement.getCredit() != null) {
            dto.setCreditId(remboursement.getCredit().getId());
        }

        return dto;
    }

    public static Remboursement toEntity(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(dto.getType());
        // Credit à gérer dans la couche service
        return remboursement;
    }
}

