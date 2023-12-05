package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.Vaccination;
import com.example.pouletfarm.repository.EntreeRepository;
import com.example.pouletfarm.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;
     @Autowired
    private EntreeRepository entreeRepository;

    public List<Vaccination> getAllVaccinations() {
        return vaccinationRepository.findAll();
    }

    public Optional<Vaccination> getVaccinationById(Long id) {
        return vaccinationRepository.findById(id);
    }

    // Sauvegarder une vaccination associée à une entrée spécifique
  // Sauvegarder une vaccination associée à une entrée spécifique
    public Vaccination saveVaccinationForEntry(Vaccination vaccination, Long entryId) {
        Optional<Entree> optionalEntree = entreeRepository.findById(entryId);
        
        if (optionalEntree.isPresent()) {
            Entree entree = optionalEntree.get();
            vaccination.setEntree(entree); // Définir l'entree pour la vaccination
            return vaccinationRepository.save(vaccination);
        } else {
            // Gérer le cas où l'entrée avec l'entryId n'existe pas
            return null;
        }
    }
    public List<Vaccination> getVaccinationsForEntry(Long entryId) {
        // Logique pour récupérer les vaccinations pour une entrée spécifique
        // Vous devrez implémenter cette logique en fonction de votre système de stockage des données
        // Par exemple, si vous utilisez une base de données, vous devrez écrire une requête pour récupérer les vaccinations associées à cette entrée.

        // C'est un exemple simplifié, vous devez adapter cela à votre système
        return vaccinationRepository.findByEntreeId(entryId);
    }
    public void deleteVaccination(Long id) {
        vaccinationRepository.deleteById(id);
    }
}
