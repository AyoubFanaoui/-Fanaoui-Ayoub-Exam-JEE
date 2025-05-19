package org.app.banckfanaoui.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date dateRemboursement;
    private double montant;
    private CreditDTO credit;
}