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
@RequestMapping("/vaccinations")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    // Récupérer toutes les vaccinations
    @GetMapping
    public ResponseEntity<List<Vaccination>> getAllVaccinations() {
        List<Vaccination> vaccinations = vaccinationService.getAllVaccinations();
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
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
    @PostMapping
    public ResponseEntity<Vaccination> saveVaccination(@RequestBody Vaccination vaccination) {
        Vaccination savedVaccination = vaccinationService.saveVaccination(vaccination);
        return new ResponseEntity<>(savedVaccination, HttpStatus.CREATED);
    }

    // Supprimer une vaccination par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccination(@PathVariable Long id) {
        vaccinationService.deleteVaccination(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
