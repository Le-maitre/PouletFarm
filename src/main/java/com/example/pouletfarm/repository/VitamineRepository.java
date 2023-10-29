package com.example.pouletfarm.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pouletfarm.model.Vitamine;

public interface VitamineRepository extends JpaRepository<Vitamine, Long> {
    
}
