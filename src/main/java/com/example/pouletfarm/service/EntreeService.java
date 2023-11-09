package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntreeService {

    @Autowired
    private EntreeRepository entreeRepository;

    // Récupérer toutes les entrées d'un utilisateur spécifique
    public List<Entree> getAllEntreesForUser(User user) {
        return entreeRepository.findByUser(user);
    }

    // Récupérer une entrée par son ID (pour un utilisateur spécifique)
    public Optional<Entree> getEntreeByIdForUser(Long id, User user) {
        return entreeRepository.findByIdAndUser(id, user);
    }

    // Créer une nouvelle entrée pour un utilisateur spécifique
    public Entree createEntreeForUser(Entree entree, User user) {
        entree.setUser(user);
        return entreeRepository.save(entree);
    }

    // Mettre à jour une entrée existante (pour un utilisateur spécifique)
    public Entree updateEntreeForUser(Long id, Entree entree, User user) {
        Optional<Entree> existingEntree = entreeRepository.findByIdAndUser(id, user);
        if (existingEntree.isPresent()) {
            Entree updatedEntree = existingEntree.get();
            updatedEntree.setNom(entree.getNom());
            updatedEntree.setDateEntree(entree.getDateEntree());
            updatedEntree.setDateSortie(entree.getDateSortie());
            updatedEntree.setNombrePoussins(entree.getNombrePoussins());
            return entreeRepository.save(updatedEntree);
        } else {
            return null;
        }
    }

    // Supprimer une entrée par son ID (pour un utilisateur spécifique)
    public void deleteEntreeForUser(Long id, User user) {
        entreeRepository.deleteByIdAndUser(id, user);
    }
}
