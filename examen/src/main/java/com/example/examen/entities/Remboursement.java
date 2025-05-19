package com.example.examen.entities;
import com.example.examen.enums.TypeRembouresement;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeRembouresement type;
    @ManyToOne
    private Credit credit;
}
