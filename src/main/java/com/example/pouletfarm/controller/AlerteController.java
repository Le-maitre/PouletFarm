package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Alerte;
import com.example.pouletfarm.service.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerte")
public class AlerteController {

    @Autowired
    private AlerteService alerteService;

    // Endpoint pour créer une nouvelle alerte
    @PostMapping("/create")
    public ResponseEntity<Alerte> createAlerte(@RequestBody Alerte alerte) {
        Alerte newAlerte = alerteService.createAlerte(alerte);
        return new ResponseEntity<>(newAlerte, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer toutes les alertes
    @GetMapping("/all")
    public ResponseEntity<List<Alerte>> getAllAlertes() {
        List<Alerte> alertes = alerteService.getAllAlertes();
        return new ResponseEntity<>(alertes, HttpStatus.OK);
    }

    // Endpoint pour récupérer une alerte par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Alerte> getAlerteById(@PathVariable Long id) {
        Alerte alerte = alerteService.getAlerteById(id);
        if (alerte != null) {
            return new ResponseEntity<>(alerte, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // // Endpoint pour mettre à jour une alerte
    // @PutMapping("/update/{id}")
    // public ResponseEntity<Alerte> updateAlerte(@PathVariable Long id, @RequestBody Alerte alerte) {
    //     Alerte updatedAlerte = alerteService.updateAlerte(id, alerte);
    //     if (updatedAlerte != null) {
    //         return new ResponseEntity<>(updatedAlerte, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // Endpoint pour supprimer une alerte par son ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAlerte(@PathVariable Long id) {
        boolean isDeleted = alerteService.deleteAlerte(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
