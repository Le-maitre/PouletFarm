package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Nourriture;
import com.example.pouletfarm.service.NourritureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nourriture")
public class NourritureController {

    @Autowired
    private NourritureService nourritureService;

    // Endpoint pour créer une nouvelle nourriture
    @PostMapping("/create")
    public ResponseEntity<Nourriture> createNourriture(@RequestBody Nourriture nourriture) {
        Nourriture newNourriture = nourritureService.createNourriture(nourriture);
        return new ResponseEntity<>(newNourriture, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer toutes les nourritures
    @GetMapping("/all")
    public ResponseEntity<List<Nourriture>> getAllNourritures() {
        List<Nourriture> nourritures = nourritureService.getAllNourritures();
        return new ResponseEntity<>(nourritures, HttpStatus.OK);
    }

    // Endpoint pour récupérer une nourriture par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Nourriture> getNourritureById(@PathVariable Long id) {
        Nourriture nourriture = nourritureService.getNourritureById(id);
        if (nourriture != null) {
            return new ResponseEntity<>(nourriture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer une nourriture
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNourriture(@PathVariable Long id) {
        boolean isDeleted = nourritureService.deleteNourriture(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
