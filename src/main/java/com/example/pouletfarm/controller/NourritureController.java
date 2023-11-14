package com.example.pouletfarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pouletfarm.model.Nourriture;
import com.example.pouletfarm.service.NourritureService;

import java.util.List;

@RestController
@RequestMapping("/api/nourriture")
public class NourritureController {

    @Autowired
    private NourritureService nourritureService;

    // Endpoint to create a new type of nourriture associated with an entree
    @PostMapping("/create/{entreeId}")
    public ResponseEntity<Nourriture> createOrUpdateNourriture(
            @PathVariable Long entreeId,
            @RequestBody Nourriture nourriture
    ) {
        Nourriture createdOrUpdatedNourriture = nourritureService.createOrUpdateNourriture(entreeId, nourriture);
        return new ResponseEntity<>(createdOrUpdatedNourriture, HttpStatus.CREATED);
    }
    

    @GetMapping("/all")
    public ResponseEntity<List<Nourriture>> getAllNourritures() {
        List<Nourriture> nourritures = nourritureService.getAllNourritures();
        return new ResponseEntity<>(nourritures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nourriture> getNourritureById(@PathVariable Long id) {
        Nourriture nourriture = nourritureService.getNourritureById(id);
        if (nourriture != null) {
            return new ResponseEntity<>(nourriture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNourriture(@PathVariable Long id) {
        boolean isDeleted = nourritureService.deleteNourriture(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/entree/{entreeId}")
    public ResponseEntity<List<Nourriture>> getNourrituresByEntreeId(@PathVariable Long entreeId) {
        List<Nourriture> nourritures = nourritureService.getNourrituresByEntreeId(entreeId);
        if (nourritures != null) {
            return new ResponseEntity<>(nourritures, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Nourriture> updateNourriture(
            @PathVariable Long id,
            @RequestBody Nourriture nourriture
    ) {
        Nourriture updatedNourriture = nourritureService.updateNourriture(id, nourriture);
        return new ResponseEntity<>(updatedNourriture, HttpStatus.OK);
    }
}

