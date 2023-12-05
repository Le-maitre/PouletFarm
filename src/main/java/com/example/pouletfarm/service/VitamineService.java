package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.Vitamine;
import com.example.pouletfarm.repository.EntreeRepository;
import com.example.pouletfarm.repository.VitamineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VitamineService {

    @Autowired
    private VitamineRepository vitamineRepository;
     @Autowired
    private EntreeRepository entreeRepository;

    public List<Vitamine> getAllVitaminesForEntry(Long entreeId) {
        // Implémentez la logique pour récupérer toutes les vitamines pour une entrée spécifique
        // Utilisez vitamineRepository pour accéder à la base de données
        return vitamineRepository.findAllByEntreeId(entreeId);
    }

    public Optional<Vitamine> getVitamineByIdForEntry(Long entreeId, Long vitamineId) {
        // Implémentez la logique pour récupérer une vitamine par son ID pour une entrée spécifique
        // Utilisez vitamineRepository pour accéder à la base de données
        return vitamineRepository.findByIdAndEntreeId(vitamineId, entreeId);
    }

    public Vitamine saveVitamineForEntry(Long entreeId, Vitamine vitamine) {
        Optional<Entree> optionalEntree = entreeRepository.findById(entreeId);
        
        if (optionalEntree.isPresent()) {
            Entree entree = optionalEntree.get();
            vitamine.setEntree(entree); // Définir l'entree pour la vaccination
            return vitamineRepository.save(vitamine);
        } else {
            // Gérer le cas où l'entrée avec l'entryId n'existe pas
            return null;
        }
    }

    public void deleteVitamineForEntry(Long entreeId, Long vitamineId) {
        // Implémentez la logique pour supprimer une vitamine par son ID pour une entrée spécifique
        // Utilisez vitamineRepository pour accéder à la base de données
        vitamineRepository.deleteByIdAndEntreeId(vitamineId, entreeId);
    }
}
