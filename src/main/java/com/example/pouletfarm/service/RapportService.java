package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Rapport;
import com.example.pouletfarm.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    // Créer un nouveau rapport
    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    // Récupérer tous les rapports
    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    // Récupérer un rapport par son ID
    public Rapport getRapportById(Long id) {
        Optional<Rapport> rapport = rapportRepository.findById(id);
        return rapport.orElse(null);
    }
   

    // Supprimer un rapport
    public boolean deleteRapport(Long id) {
        Optional<Rapport> rapport = rapportRepository.findById(id);

        if (rapport.isPresent()) {
            rapportRepository.delete(rapport.get());
            return true;
        } else {
            return false;
        }
    }
}
