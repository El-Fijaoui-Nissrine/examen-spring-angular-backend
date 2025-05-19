package com.example.examen.repositories;

import com.example.examen.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement,Long> {


    List<Remboursement> findByCreditId( Long id);
}
