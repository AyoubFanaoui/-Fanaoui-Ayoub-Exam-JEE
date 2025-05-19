package org.app.banckfanaoui.entites;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.app.banckfanaoui.enums.TypeBien;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {

    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;

    // Getters & Setters
}