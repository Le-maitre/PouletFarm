package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.Nourriture;

@Repository
public interface NourritureRepository extends JpaRepository<Nourriture, Long> {
    Nourriture findByTypeNourritureAndEntree(String typeNourriture, Entree entree);
    Nourriture findByEntreeAndTypeNourriture(Entree entree, String typeNourriture);
}
