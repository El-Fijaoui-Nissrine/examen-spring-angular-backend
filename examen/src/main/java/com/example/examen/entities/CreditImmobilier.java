package com.example.examen.entities;

import com.example.examen.enums.TypeBien;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("IMOB")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilier extends Credit{
    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;
}
