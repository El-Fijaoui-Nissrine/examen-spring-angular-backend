package com.example.examen.dtos;

import com.example.examen.enums.TypeRembouresement;
import lombok.Data;

import java.util.Date;
@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private TypeRembouresement type;
}
