package com.example.examen.repositories;

import com.example.examen.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement,Long> {
}
