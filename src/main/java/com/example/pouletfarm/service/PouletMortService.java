package com.example.pouletfarm.service;

import com.example.pouletfarm.model.PouletMort;
import com.example.pouletfarm.repository.PouletMortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PouletMortService {

    @Autowired
    private PouletMortRepository pouletMortRepository;

    // Récupérer tous les poulets morts
    public List<PouletMort> getAllPouletsMorts() {
        return pouletMortRepository.findAll();
    }

    // Récupérer un poulet mort par son ID
    public Optional<PouletMort> getPouletMortById(Long id) {
        return pouletMortRepository.findById(id);
    }

    // Ajouter un nouveau poulet mort
    public PouletMort savePouletMort(PouletMort pouletMort) {
        return pouletMortRepository.save(pouletMort);
    }

    // Supprimer un poulet mort par son ID
    public void deletePouletMort(Long id) {
        pouletMortRepository.deleteById(id);
    }
}
