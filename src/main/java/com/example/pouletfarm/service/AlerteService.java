package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Alerte;
import com.example.pouletfarm.repository.AlerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlerteService {

    @Autowired
    private AlerteRepository alerteRepository;

    // Créer une nouvelle alerte
    public Alerte createAlerte(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    // Récupérer toutes les alertes
    public List<Alerte> getAllAlertes() {
        return alerteRepository.findAll();
    }

    // Récupérer une alerte par son ID
    public Alerte getAlerteById(Long id) {
        Optional<Alerte> alerte = alerteRepository.findById(id);
        return alerte.orElse(null);
    }

    // // Mettre à jour une alerte
    // public Alerte updateAlerte(Long id, Alerte newAlerte) {
    //     Optional<Alerte> alerteOptional = alerteRepository.findById(id);
    //     if (alerteOptional.isPresent()) {
    //         Alerte alerte = alerteOptional.get();
    //         alerte.setNom(newAlerte.getNom());
    //         alerte.setDescription(newAlerte.getDescription());
    //         return alerteRepository.save(alerte);
    //     }
    //     return null;
    // }

    // Supprimer une alerte par son ID
    public boolean deleteAlerte(Long id) {
        Optional<Alerte> alerteOptional = alerteRepository.findById(id);
        if (alerteOptional.isPresent()) {
            alerteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
