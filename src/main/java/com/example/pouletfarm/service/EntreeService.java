package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.repository.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntreeService {

    @Autowired
    private EntreeRepository entreeRepository;

    // Méthode pour créer une nouvelle entrée
    public Entree createEntree(Entree entree) {
        return entreeRepository.save(entree);
    }

    // Méthode pour récupérer toutes les entrées
    public List<Entree> getAllEntrees() {
        return entreeRepository.findAll();
    }

    // Méthode pour récupérer une entrée par son ID
    public Entree getEntreeById(Long id) {
        Optional<Entree> entree = entreeRepository.findById(id);
        return entree.orElse(null);
    }

    // Méthode pour mettre à jour une entrée
    public Entree updateEntree(Long id, Entree newEntree) {
        Optional<Entree> optionalEntree = entreeRepository.findById(id);
        if (optionalEntree.isPresent()) {
            Entree entree = optionalEntree.get();
            entree.setDateEntree(newEntree.getDateEntree());
            entree.setNombrePoussins(newEntree.getNombrePoussins());
            // Ajouter d'autres attributs à mettre à jour au besoin
            return entreeRepository.save(entree);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer une entrée
    public boolean deleteEntree(Long id) {
        Optional<Entree> optionalEntree = entreeRepository.findById(id);
        if (optionalEntree.isPresent()) {
            entreeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
