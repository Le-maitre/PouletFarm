package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Vaccination;
import com.example.pouletfarm.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/vaccinations")
public class VaccinationController {    

    @Autowired
    private VaccinationService vaccinationService;

    // Récupérer toutes les vaccinations
    @GetMapping
    public ResponseEntity<List<Vaccination>> getAllVaccinations() {
        List<Vaccination> vaccinations = vaccinationService.getAllVaccinations();
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
    }
     // Récupérer toutes les vaccinations pour une entrée précise
     @GetMapping("/entry/{entryId}/vaccinations")
     public ResponseEntity<List<Vaccination>> getVaccinationsForEntry(@PathVariable Long entryId) {
         List<Vaccination> vaccinationsForEntry = vaccinationService.getVaccinationsForEntry(entryId);
         
         if (!vaccinationsForEntry.isEmpty()) {
             return new ResponseEntity<>(vaccinationsForEntry, HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }
    // Récupérer une vaccination par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Vaccination> getVaccinationById(@PathVariable Long id) {
        Vaccination vaccination = vaccinationService.getVaccinationById(id).orElse(null);
        if (vaccination != null) {
            return new ResponseEntity<>(vaccination, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ajouter une nouvelle vaccination
    // Ajouter une nouvelle vaccination pour une entrée spécifique
    @PostMapping("/entry/{entryId}")
    public ResponseEntity<Vaccination> saveVaccinationForEntry(
            @RequestBody Vaccination vaccination,
            @PathVariable Long entryId) {

        // Vérifier si l'entrée avec entryId existe avant d'associer la vaccination
        // Vous pouvez implémenter la logique de vérification ici

        Vaccination savedVaccination = vaccinationService.saveVaccinationForEntry(vaccination, entryId);
        
        if (savedVaccination != null) {
            return new ResponseEntity<>(savedVaccination, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer une vaccination par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccination(@PathVariable Long id) {
        vaccinationService.deleteVaccination(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}