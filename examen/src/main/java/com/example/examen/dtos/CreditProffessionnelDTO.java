package com.example.examen.dtos;

import com.example.examen.entities.Client;
import com.example.examen.enums.CreditStatut;
import lombok.Data;

import java.util.Date;

@Data
public class CreditProffessionnelDTO extends CreditDTO{
    private Long id;
    private Date dateDemande;
    private Date dateAcceptation;
    private CreditStatut statut;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private Client client;
    private String motif;
    private String raisonSociale;
}
