package org.app.banckfanaoui.dtos;



import java.time.LocalDate;

import lombok.Data;
import org.app.banckfanaoui.enums.TypeRemboursement;

@Data
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypeRemboursement type;

    private Long creditId; // ID du crédit lié
}
