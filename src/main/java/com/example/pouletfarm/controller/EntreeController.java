package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.service.EntreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entree")
public class EntreeController {

    @Autowired
    private EntreeService entreeService;

    // Endpoint pour créer une nouvelle entrée
    @PostMapping("/create")
    public ResponseEntity<Entree> createEntree(@RequestBody Entree entree) {
        Entree newEntree = entreeService.createEntree(entree);
        return new ResponseEntity<>(newEntree, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer toutes les entrées
    @GetMapping("/all")
    public ResponseEntity<List<Entree>> getAllEntrees() {
        List<Entree> entrees = entreeService.getAllEntrees();
        return new ResponseEntity<>(entrees, HttpStatus.OK);
    }

    // Endpoint pour récupérer une entrée par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Entree> getEntreeById(@PathVariable Long id) {
        Entree entree = entreeService.getEntreeById(id);
        if (entree != null) {
            return new ResponseEntity<>(entree, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour mettre à jour une entrée
    @PutMapping("/update/{id}")
    public ResponseEntity<Entree> updateEntree(@PathVariable Long id, @RequestBody Entree entree) {
        Entree updatedEntree = entreeService.updateEntree(id, entree);
        if (updatedEntree != null) {
            return new ResponseEntity<>(updatedEntree, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer une entrée
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntree(@PathVariable Long id) {
        boolean isDeleted = entreeService.deleteEntree(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
