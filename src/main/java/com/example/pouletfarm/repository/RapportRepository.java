package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pouletfarm.model.Rapport;

public interface RapportRepository extends JpaRepository<Rapport, Long>  {
    
}
