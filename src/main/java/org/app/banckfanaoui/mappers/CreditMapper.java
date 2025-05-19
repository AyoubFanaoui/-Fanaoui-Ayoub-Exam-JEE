package org.app.banckfanaoui.mappers;

import org.app.banckfanaoui.dtos.CreditDTO;
import org.app.banckfanaoui.entites.Credit;
import java.util.*;


import org.app.banckfanaoui.entites.Remboursement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.stream.Collectors;

public class CreditMapper {

    public static CreditDTO toDTO(Credit credit) {
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant().doubleValue());
        dto.setDuree(credit.getDuree());
        dto.setTauxInteret(credit.getTauxInteret());

        if (credit.getClient() != null) {
            dto.setClientId(credit.getClient().getId());
        }

        if (credit.getRemboursements() != null) {
            List<Long> remboursementIds = credit.getRemboursements().stream()
                    .map(Remboursement::getId)
                    .collect(Collectors.toList());
            dto.setRemboursementIds(remboursementIds);
        }

        dto.setTypeCredit(credit.getClass().getSimpleName().toUpperCase());

        // Champs spécifiques par type
        if (credit instanceof org.app.banckfanaoui.entites.CreditImmobilier) {
            dto.setTypeBien(((org.app.banckfanaoui.entites.CreditImmobilier) credit).getTypeBien().name());
        } else if (credit instanceof org.app.banckfanaoui.entites.CreditPersonnel) {
            dto.setMotif(((org.app.banckfanaoui.entites.CreditPersonnel) credit).getMotif());
        } else if (credit instanceof org.app.banckfanaoui.entites.CreditProfessionnel) {
            dto.setMotif(((org.app.banckfanaoui.entites.CreditProfessionnel) credit).getMotif());
            dto.setRaisonSociale(((org.app.banckfanaoui.entites.CreditProfessionnel) credit).getRaisonSociale());
        }

        return dto;
    }

    public static Credit toEntity(CreditDTO dto) {
        Credit credit;

        switch (dto.getTypeCredit()) {
            case "CREDITIMMOBILIER":
                var creditImmobilier = new org.app.banckfanaoui.entites.CreditImmobilier();
                if (dto.getTypeBien() != null) {
                    creditImmobilier.setTypeBien(org.app.banckfanaoui.enums.TypeBien.valueOf(dto.getTypeBien()));
                }
                credit = creditImmobilier;
                break;
            case "CREDITPERSONNEL":
                var creditPersonnel = new org.app.banckfanaoui.entites.CreditPersonnel();
                creditPersonnel.setMotif(dto.getMotif());
                credit = creditPersonnel;
                break;
            case "CREDITPROFESSIONNEL":
                var creditPro = new org.app.banckfanaoui.entites.CreditProfessionnel();
                creditPro.setMotif(dto.getMotif());
                creditPro.setRaisonSociale(dto.getRaisonSociale());
                credit = creditPro;
                break;
            default:
                throw new IllegalArgumentException("Type de crédit inconnu: " + dto.getTypeCredit());
        }

        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcception(dto.getDateAcception());
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());

        // Client et remboursements à gérer dans la couche service

        return credit;
    }
}