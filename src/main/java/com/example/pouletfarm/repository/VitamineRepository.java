package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.Vitamine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VitamineRepository extends JpaRepository<Vitamine, Long> {

    // Récupérer toutes les vitamines pour une entrée spécifique
    List<Vitamine> findAllByEntreeId(Long entreeId);

    // Récupérer une vitamine par son ID pour une entrée spécifique
    Optional<Vitamine> findByIdAndEntreeId(Long id, Long entreeId);

    // Supprimer une vitamine par son ID pour une entrée spécifique
    void deleteByIdAndEntreeId(Long id, Long entreeId);
}
