package org.app.banckfanaoui.dtos;



import java.time.LocalDate;

import org.app.banckfanaoui.enums.TypeRemboursement;

public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypeRemboursement type;

    private Long creditId;

    public Long getCreditId() {
        return creditId;
    }

    // Getters & Setters
}
