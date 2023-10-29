package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Nourriture;
import com.example.pouletfarm.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NourritureService {

    @Autowired
    private NourritureRepository nourritureRepository;

    // Méthode pour créer une nouvelle nourriture
    public Nourriture createNourriture(Nourriture nourriture) {
        return nourritureRepository.save(nourriture);
    }

    // Méthode pour récupérer toutes les nourritures
    public List<Nourriture> getAllNourritures() {
        return nourritureRepository.findAll();
    }

    // Méthode pour récupérer une nourriture par son ID
    public Nourriture getNourritureById(Long id) {
        Optional<Nourriture> nourriture = nourritureRepository.findById(id);
        return nourriture.orElse(null);
    }

    // Méthode pour supprimer une nourriture
    public boolean deleteNourriture(Long id) {
        Optional<Nourriture> nourriture = nourritureRepository.findById(id);

        if (nourriture.isPresent()) {
            nourritureRepository.delete(nourriture.get());
            return true;
        } else {
            return false;
        }
    }
}
