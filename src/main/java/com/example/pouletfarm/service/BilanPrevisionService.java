package com.example.pouletfarm.service;

import com.example.pouletfarm.model.BilanPrevision;
import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.repository.BilanPrevisionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class BilanPrevisionService {

    private final BilanPrevisionRepository bilanPrevisionRepository;

    // Constructeur
    public BilanPrevisionService(BilanPrevisionRepository bilanPrevisionRepository) {
        this.bilanPrevisionRepository = bilanPrevisionRepository;
    }

    // Récupérer tous les bilans prévisionnels associés à une entree spécifique
    public List<BilanPrevision> getBilanPrevisionsByEntree(Entree entree) {
        return bilanPrevisionRepository.findByEntree(entree);
    }

    // Récupérer un bilan prévisionnel par son ID
    public Optional<BilanPrevision> getBilanPrevisionById(Long id) {
        return bilanPrevisionRepository.findById(id);
    }

    // Créer un nouveau bilan prévisionnel
    public BilanPrevision createBilanPrevision(BilanPrevision bilanPrevision) {
        return bilanPrevisionRepository.save(bilanPrevision);
    }

    // Mettre à jour un bilan prévisionnel existant
    public BilanPrevision updateBilanPrevision(Long id, BilanPrevision bilanPrevision) {
        Optional<BilanPrevision> existingBilanPrevision = bilanPrevisionRepository.findById(id);
        if (existingBilanPrevision.isPresent()) {
            BilanPrevision updatedBilanPrevision = existingBilanPrevision.get();
            updatedBilanPrevision.setNom(bilanPrevision.getNom());
            updatedBilanPrevision.setEntree(bilanPrevision.getEntree());
            return bilanPrevisionRepository.save(updatedBilanPrevision);
        } else {
            return null;
        }
    }

    // Supprimer un bilan prévisionnel par son ID
    public void deleteBilanPrevision(Long id) {
        bilanPrevisionRepository.deleteById(id);
    }
}
