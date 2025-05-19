package com.example.examen.entities;
import com.example.examen.enums.CreditStatut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDemande;

    @Temporal(TemporalType.DATE)
    private Date dateAcceptation;
    @Enumerated(EnumType.STRING)
private CreditStatut statut;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}
