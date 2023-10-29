package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Vitamine;
import com.example.pouletfarm.service.VitamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitamines")
public class VitamineController {

    @Autowired
    private VitamineService vitamineService;

    // Récupérer toutes les vitamines
    @GetMapping
    public ResponseEntity<List<Vitamine>> getAllVitamines() {
        List<Vitamine> vitamines = vitamineService.getAllVitamines();
        return new ResponseEntity<>(vitamines, HttpStatus.OK);
    }

    // Récupérer une vitamine par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Vitamine> getVitamineById(@PathVariable Long id) {
        Vitamine vitamine = vitamineService.getVitamineById(id).orElse(null);
        if (vitamine != null) {
            return new ResponseEntity<>(vitamine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ajouter une nouvelle vitamine
    @PostMapping
    public ResponseEntity<Vitamine> saveVitamine(@RequestBody Vitamine vitamine) {
        Vitamine savedVitamine = vitamineService.saveVitamine(vitamine);
        return new ResponseEntity<>(savedVitamine, HttpStatus.CREATED);
    }

    // Supprimer une vitamine par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitamine(@PathVariable Long id) {
        vitamineService.deleteVitamine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
