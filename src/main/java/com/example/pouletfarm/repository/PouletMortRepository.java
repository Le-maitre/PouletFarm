package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pouletfarm.model.PouletMort;

public interface PouletMortRepository extends JpaRepository<PouletMort, Long>  {
    
}
