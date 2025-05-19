package org.app.banckfanaoui.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.app.banckfanaoui.enums.StatutCredit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_credit")
public abstract class Credit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    private LocalDate dateAcception;
    private double montant;
    private int duree;
    private double tauxInteret;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "credit")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Remboursement> remboursements;

    public Long getId() {
        return id;
    }

    public BigDecimal getMontant() {
        return new BigDecimal(montant);
    }

    public String getStatutCredit() {
        return statut.toString();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(Long creditId) {
        this.id = creditId;
    }


    // Getters & Setters
}