package org.app.banckfanaoui.dtos;

import lombok.Data;

import java.util.*;

@Data
public class CreditDTO {
    private Long id;
    private double montant;
    private double taux;
    private int dureeMois;
    private Date dateDebut;
    private String type; // Pour savoir si c'est personnel ou immobilier
    private ClientDTO client;
    private List<RemboursementDTO> remboursements;
}