package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.TacheBilan;
import com.example.pouletfarm.service.TacheBilanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tachebilan")
public class TacheBilanController {

    @Autowired
    private TacheBilanService tacheBilanService;

    // Endpoint pour créer une nouvelle tâche
    @PostMapping("/create")
    public ResponseEntity<TacheBilan> createTacheBilan(@RequestBody TacheBilan tacheBilan) {
        TacheBilan newTacheBilan = tacheBilanService.createTacheBilan(tacheBilan);
        return new ResponseEntity<>(newTacheBilan, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer toutes les tâches
    @GetMapping("/all")
    public ResponseEntity<List<TacheBilan>> getAllTacheBilans() {
        List<TacheBilan> tacheBilans = tacheBilanService.getAllTacheBilans();
        return new ResponseEntity<>(tacheBilans, HttpStatus.OK);
    }

    // Endpoint pour récupérer une tâche par son ID
    @GetMapping("/{id}")
    public ResponseEntity<TacheBilan> getTacheBilanById(@PathVariable Long id) {
        TacheBilan tacheBilan = tacheBilanService.getTacheBilanById(id);
        
        if (tacheBilan != null) {
            return new ResponseEntity<>(tacheBilan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour mettre à jour une tâche
    @PutMapping("/update/{id}")
    public ResponseEntity<TacheBilan> updateTacheBilan(@PathVariable Long id, @RequestBody TacheBilan tacheBilan) {
        TacheBilan updatedTacheBilan = tacheBilanService.updateTacheBilan(id, tacheBilan);

        if (updatedTacheBilan != null) {
            return new ResponseEntity<>(updatedTacheBilan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer une tâche
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTacheBilan(@PathVariable Long id) {
        boolean isDeleted = tacheBilanService.deleteTacheBilan(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
