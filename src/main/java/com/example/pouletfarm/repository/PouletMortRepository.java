package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.PouletMort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PouletMortRepository extends JpaRepository<PouletMort, Long> {
    List<PouletMort> findByEntreeId(Long entreeId);
}
