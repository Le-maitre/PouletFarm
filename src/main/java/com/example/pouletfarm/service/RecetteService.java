package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.Recette;
import com.example.pouletfarm.repository.EntreeRepository;
import com.example.pouletfarm.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    @Autowired
    private EntreeRepository entreeRepository;

    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    public Optional<Recette> getRecetteById(Long id) {
        return recetteRepository.findById(id);
    }

    public Recette saveRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    public void deleteRecette(Long id) {
        recetteRepository.deleteById(id);
    }

    public List<Recette> getRecetteByEntreeId(Long entreeId) {
        return recetteRepository.findByEntreeId(entreeId);
    }

    public Recette saveRecetteForEntree(Long entreeId, Recette recette) {
        Entree entree = entreeRepository.findById(entreeId).orElse(null);
        if (entree != null) {
            recette.setEntree(entree);
            int nombrePoussins = entree.getNombrePoussins();
            int nombrePertesDeclarees = recette.getNombre();

            // Déduction du nombre de poussins en fonction des pertes déclarées
            entree.setNombrePoussins(nombrePoussins - nombrePertesDeclarees);

            // Sauvegarde de l'entité Entree mise à jour
            entreeRepository.save(entree);

            // Sauvegarde de l'enregistrement de PouletMort
            return recetteRepository.save(recette);
        } else {
            return null;
        }
    }

    public void deleteRecetteForEntree(Long entreeId, Long id) {
        Optional<Recette> recetteOptional = recetteRepository.findById(id);
        recetteOptional.ifPresent(recette -> {
            Entree entree = recette.getEntree();
            if (entree != null && entree.getId().equals(entreeId)) {
                int nombrePoussins = entree.getNombrePoussins();
                int nombrePertesDeclarees = recette.getNombre();

                // Ajout du nombre de pertes au nombre de poussins de l'entrée
                entree.setNombrePoussins(nombrePoussins + nombrePertesDeclarees);
                entreeRepository.save(entree);

                recetteRepository.delete(recette);
            }
        });
    }
}
