package org.app.banckfanaoui.dtos;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import org.app.banckfanaoui.enums.StatutCredit;

@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private StatutCredit statut;
    private LocalDate dateAcception;
    private double montant;
    private int duree;
    private double tauxInteret;

    private Long clientId; // liaison vers client

    private List<Long> remboursementIds; // liste des remboursements

    private String typeCredit; // IMMOBILIER, PERSONNEL, PROFESSIONNEL

    // Champs spécifiques par type (optionnel, on peut les gérer dans des sous-DTOs)
    private String motif; // pour personnel et professionnel
    private String raisonSociale; // professionnel uniquement
    private String typeBien; // pour immobilier (string pour simplifier)

    public Long getClientId() {

    }

    // Getters & Setters
}
