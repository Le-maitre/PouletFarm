package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.Nourriture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NourritureRepository extends JpaRepository<Nourriture, Long> {
}
