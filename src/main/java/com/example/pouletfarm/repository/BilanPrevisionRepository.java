package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.BilanPrevision;
import com.example.pouletfarm.model.Entree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BilanPrevisionRepository extends JpaRepository<BilanPrevision, Long> {
    List<BilanPrevision> findByEntree(Entree entree);
}
