package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.PouletMort;
import com.example.pouletfarm.repository.EntreeRepository;
import com.example.pouletfarm.repository.PouletMortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PouletMortService {

    @Autowired
    private PouletMortRepository pouletMortRepository;

    @Autowired
    private EntreeRepository entreeRepository;

    public List<PouletMort> getAllPouletsMorts() {
        return pouletMortRepository.findAll();
    }

    public Optional<PouletMort> getPouletMortById(Long id) {
        return pouletMortRepository.findById(id);
    }

    public PouletMort savePouletMort(PouletMort pouletMort) {
        return pouletMortRepository.save(pouletMort);
    }

    public void deletePouletMort(Long id) {
        pouletMortRepository.deleteById(id);
    }

    public List<PouletMort> getPouletMortsByEntreeId(Long entreeId) {
        return pouletMortRepository.findByEntreeId(entreeId);
    }

    public PouletMort savePouletMortForEntree(Long entreeId, PouletMort pouletMort) {
        Entree entree = entreeRepository.findById(entreeId).orElse(null);
        if (entree != null) {
            pouletMort.setEntree(entree);
            int nombrePoussins = entree.getNombrePoussins();
            int nombrePertesDeclarees = pouletMort.getNombre();

            // Déduction du nombre de poussins en fonction des pertes déclarées
            entree.setNombrePoussins(nombrePoussins - nombrePertesDeclarees);

            // Sauvegarde de l'entité Entree mise à jour
            entreeRepository.save(entree);

            // Sauvegarde de l'enregistrement de PouletMort
            return pouletMortRepository.save(pouletMort);
        } else {
            return null;
        }
    }

    public void deletePouletMortForEntree(Long entreeId, Long id) {
        Optional<PouletMort> pouletMortOptional = pouletMortRepository.findById(id);
        pouletMortOptional.ifPresent(pouletMort -> {
            Entree entree = pouletMort.getEntree();
            if (entree != null && entree.getId().equals(entreeId)) {
                int nombrePoussins = entree.getNombrePoussins();
                int nombrePertesDeclarees = pouletMort.getNombre();

                // Ajout du nombre de pertes au nombre de poussins de l'entrée
                entree.setNombrePoussins(nombrePoussins + nombrePertesDeclarees);
                entreeRepository.save(entree);

                pouletMortRepository.delete(pouletMort);
            }
        });
    }
}
