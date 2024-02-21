package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> findByEntreeId(Long entreeId);
}
