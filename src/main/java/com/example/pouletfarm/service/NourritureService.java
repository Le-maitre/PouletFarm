package com.example.pouletfarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.Nourriture;
import com.example.pouletfarm.repository.EntreeRepository;
import com.example.pouletfarm.repository.NourritureRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class NourritureService {

    @Autowired
    private NourritureRepository nourritureRepository;

    @Autowired
    private EntreeRepository entreeRepository;

    public List<Nourriture> getAllNourritures() {
        return nourritureRepository.findAll();
    }

    public Nourriture getNourritureById(Long id) {
        Optional<Nourriture> optionalNourriture = nourritureRepository.findById(id);
        return optionalNourriture.orElse(null);
    }

    public boolean deleteNourriture(Long id) {
        Optional<Nourriture> optionalNourriture = nourritureRepository.findById(id);
        if (optionalNourriture.isPresent()) {
            nourritureRepository.delete(optionalNourriture.get());
            return true;
        }
        return false;
    }

    public List<Nourriture> getNourrituresByEntreeId(Long entreeId) {
        Optional<Entree> optionalEntree = entreeRepository.findById(entreeId);
        if (optionalEntree.isPresent()) {
            Entree entree = optionalEntree.get();
            return entree.getNourritures();
        }
        return null;
    }

    public Nourriture createOrUpdateNourriture(Long entreeId, Nourriture nourriture) {
        Optional<Entree> optionalEntree = entreeRepository.findById(entreeId);
        if (optionalEntree.isPresent()) {
            Entree entree = optionalEntree.get();
            String typeNourriture = nourriture.getTypeNourriture();
            Nourriture existingNourriture = nourritureRepository.findByEntreeAndTypeNourriture(entree, typeNourriture);

            if (existingNourriture != null) {
                // If the specific type of food already exists for this entry, add the quantity
                existingNourriture.setQuantite(existingNourriture.getQuantite() + nourriture.getQuantite());
                return nourritureRepository.save(existingNourriture);
            } else {
                // If the specific type of food doesn't exist for this entry, create a new one
                nourriture.setEntree(entree);
                return nourritureRepository.save(nourriture);
            }
        } else {
            throw new EntityNotFoundException("Entree not found with ID: " + entreeId);
        }
    }
    public Nourriture updateNourriture(Long id, Nourriture nourriture) {
        Optional<Nourriture> existingNourritureOptional = nourritureRepository.findById(id);
        if (existingNourritureOptional.isPresent()) {
            Nourriture existingNourriture = existingNourritureOptional.get();
            existingNourriture.setTypeNourriture(nourriture.getTypeNourriture());
            existingNourriture.setQuantite(nourriture.getQuantite());
            // Set other fields to update
            
            return nourritureRepository.save(existingNourriture);
        } else {
            throw new EntityNotFoundException("Nourriture not found with ID: " + id);
        }
    }

}
