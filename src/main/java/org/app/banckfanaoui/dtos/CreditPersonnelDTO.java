package org.app.banckfanaoui.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditPersonnelDTO extends CreditDTO {
    private String usage;
}
