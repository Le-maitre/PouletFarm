package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public Entree updateEntryForUser(Long entryId, Entree updatedEntry, Long userId) {
        Optional<Entree> optionalEntry = entreeRepository.findById(entryId);

        if (optionalEntry.isPresent()) {
            Entree existingEntry = optionalEntry.get();

            // Check if the entry belongs to the specified user
            if (existingEntry.getUser().getId().equals(userId)) {
                existingEntry.setNom(updatedEntry.getNom());
                existingEntry.setNombrePoussins(updatedEntry.getNombrePoussins());
                existingEntry.setDateEntree(updatedEntry.getDateEntree());
                existingEntry.setDateSortie(updatedEntry.getDateSortie());
                Entree savedEntry = entreeRepository.save(existingEntry);
                return savedEntry;
            } else {
                // Entry does not belong to the specified user, handle the scenario
                return null; // Or throw an exception
            }
        } else {
            // Entry with the provided ID not found
            return null; // Or throw an exception
        }
    }
    // Supprimer une entrée par son ID (pour un utilisateur spécifique)
    @Transactional
    public void deleteEntreeForUser(Long id, User user) {
        entreeRepository.deleteByIdAndUser(id, user);
    }
}
