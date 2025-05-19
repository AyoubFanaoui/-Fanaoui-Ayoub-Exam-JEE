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

    private Long clientId; // ID du client

    private List<Long> remboursementIds; // Liste des IDs de remboursements

    private String typeCredit; // IMMOBILIER, PERSONNEL, PROFESSIONNEL

    // Champs spécifiques par type
    private String motif;        // Personnel, Professionnel
    private String raisonSociale; // Professionnel
    private String typeBien;     // Immobilier (stocké en String pour simplifier)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public StatutCredit getStatut() {
        return statut;
    }

    public void setStatut(StatutCredit statut) {
        this.statut = statut;
    }

    public LocalDate getDateAcception() {
        return dateAcception;
    }

    public void setDateAcception(LocalDate dateAcception) {
        this.dateAcception = dateAcception;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getRemboursementIds() {
        return remboursementIds;
    }

    public void setRemboursementIds(List<Long> remboursementIds) {
        this.remboursementIds = remboursementIds;
    }

    public String getTypeCredit() {
        return typeCredit;
    }

    public void setTypeCredit(String typeCredit) {
        this.typeCredit = typeCredit;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(String typeBien) {
        this.typeBien = typeBien;
    }
}

