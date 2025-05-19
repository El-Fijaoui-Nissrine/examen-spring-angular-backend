package com.example.examen.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("PERS")

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel {
    private String motif;
}
