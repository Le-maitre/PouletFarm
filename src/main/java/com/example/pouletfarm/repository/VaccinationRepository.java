package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.Vaccination;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
    // Méthode pour récupérer les vaccinations par ID d'entrée
    List<Vaccination> findByEntreeId(Long entreeId);

}
