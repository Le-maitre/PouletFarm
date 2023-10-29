package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pouletfarm.model.Alerte;

public interface AlerteRepository  extends JpaRepository<Alerte, Long>{
    
}
