package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Vitamine;
import com.example.pouletfarm.service.VitamineService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/entree/{entryId}/vitamines")
public class VitamineController {

    @Autowired
    private VitamineService vitamineService;

    // Récupérer toutes les vitamines pour une entrée spécifique
    @GetMapping
    public ResponseEntity<List<Vitamine>> getAllVitaminesForEntry(@PathVariable Long entryId) {
        List<Vitamine> vitamines = vitamineService.getAllVitaminesForEntry(entryId);
        return new ResponseEntity<>(vitamines, HttpStatus.OK);
    }

    // Récupérer une vitamine par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Vitamine> getVitamineById(@PathVariable Long entryId, @PathVariable Long id) {
        Vitamine vitamine = vitamineService.getVitamineByIdForEntry(entryId, id).orElse(null);
        if (vitamine != null) {
            return new ResponseEntity<>(vitamine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ajouter une nouvelle vitamine pour une entrée spécifique
    @PostMapping
    public ResponseEntity<Vitamine> saveVitamineForEntry(@PathVariable Long entryId, @RequestBody Vitamine vitamine) {
        Vitamine savedVitamine = vitamineService.saveVitamineForEntry(entryId, vitamine);
        return new ResponseEntity<>(savedVitamine, HttpStatus.CREATED);
    }

    // Supprimer une vitamine par son ID pour une entrée spécifique
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitamine(@PathVariable Long entryId, @PathVariable Long id) {
        vitamineService.deleteVitamineForEntry(entryId, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
