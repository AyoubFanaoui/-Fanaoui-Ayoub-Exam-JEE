package org.app.banckfanaoui.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditImmobilierDTO extends CreditDTO {
    private String adresseBien;
    private double valeurBien;
}