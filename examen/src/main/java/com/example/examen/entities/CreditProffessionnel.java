package com.example.examen.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("Prof")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditProffessionnel extends  Credit{
    private String motif;
    private String raisonSociale;
}
