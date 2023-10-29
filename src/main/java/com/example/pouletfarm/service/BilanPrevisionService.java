package com.example.pouletfarm.service;

import com.example.pouletfarm.model.BilanPrevision;
import com.example.pouletfarm.repository.BilanPrevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilanPrevisionService {

    @Autowired
    private BilanPrevisionRepository bilanPrevisionRepository;

    // Méthode pour créer un nouveau bilan prévisionnel
    public BilanPrevision createBilanPrevision(BilanPrevision bilanPrevision) {
        return bilanPrevisionRepository.save(bilanPrevision);
    }

    // Méthode pour récupérer tous les bilans prévisionnels
    public List<BilanPrevision> getAllBilanPrevisions() {
        return bilanPrevisionRepository.findAll();
    }

    // Méthode pour récupérer un bilan prévisionnel par son ID
    public BilanPrevision getBilanPrevisionById(Long id) {
        Optional<BilanPrevision> optionalBilanPrevision = bilanPrevisionRepository.findById(id);
        return optionalBilanPrevision.orElse(null);
    }

    // // Méthode pour mettre à jour un bilan prévisionnel
    // public BilanPrevision updateBilanPrevision(Long id, BilanPrevision newBilanPrevision) {
    //     Optional<BilanPrevision> optionalBilanPrevision = bilanPrevisionRepository.findById(id);
    //     if (optionalBilanPrevision.isPresent()) {
    //         BilanPrevision oldBilanPrevision = optionalBilanPrevision.get();
    //         oldBilanPrevision.setNom(newBilanPrevision.getNom());
    //         oldBilanPrevision.setPrix(newBilanPrevision.getPrix());
    //         return bilanPrevisionRepository.save(oldBilanPrevision);
    //     } else {
    //         return null; // Si le bilan prévisionnel n'existe pas, renvoie null
    //     }
    // }

    // Méthode pour supprimer un bilan prévisionnel par son ID
    public boolean deleteBilanPrevision(Long id) {
        Optional<BilanPrevision> optionalBilanPrevision = bilanPrevisionRepository.findById(id);
        if (optionalBilanPrevision.isPresent()) {
            bilanPrevisionRepository.delete(optionalBilanPrevision.get());
            return true; // Renvoie true si la suppression a réussi
        } else {
            return false; // Renvoie false si le bilan prévisionnel n'a pas été trouvé
        }
    }
}
