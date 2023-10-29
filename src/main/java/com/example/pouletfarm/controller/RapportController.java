package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Rapport;
import com.example.pouletfarm.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapport")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    // Endpoint pour créer un nouveau rapport
    @PostMapping("/create")
    public ResponseEntity<Rapport> createRapport(@RequestBody Rapport rapport) {
        Rapport newRapport = rapportService.createRapport(rapport);
        return new ResponseEntity<>(newRapport, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les rapports
    @GetMapping("/all")
    public ResponseEntity<List<Rapport>> getAllRapports() {
        List<Rapport> rapports = rapportService.getAllRapports();
        return new ResponseEntity<>(rapports, HttpStatus.OK);
    }

    // Endpoint pour récupérer un rapport par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable Long id) {
        Rapport rapport = rapportService.getRapportById(id);

        if (rapport != null) {
            return new ResponseEntity<>(rapport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un rapport
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Long id) {
        boolean isDeleted = rapportService.deleteRapport(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
