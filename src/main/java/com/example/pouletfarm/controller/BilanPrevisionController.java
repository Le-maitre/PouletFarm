package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.BilanPrevision;
import com.example.pouletfarm.service.BilanPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bilanprevision")
public class BilanPrevisionController {

    @Autowired
    private BilanPrevisionService bilanPrevisionService;

    // Endpoint pour créer un nouveau bilan prévisionnel
    @PostMapping("/create")
    public ResponseEntity<BilanPrevision> createBilanPrevision(@RequestBody BilanPrevision bilanPrevision) {
        BilanPrevision newBilanPrevision = bilanPrevisionService.createBilanPrevision(bilanPrevision);
        return new ResponseEntity<>(newBilanPrevision, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les bilans prévisionnels
    @GetMapping("/all")
    public ResponseEntity<List<BilanPrevision>> getAllBilanPrevisions() {
        List<BilanPrevision> bilanPrevisions = bilanPrevisionService.getAllBilanPrevisions();
        return new ResponseEntity<>(bilanPrevisions, HttpStatus.OK);
    }

    // Endpoint pour récupérer un bilan prévisionnel par son ID
    @GetMapping("/{id}")
    public ResponseEntity<BilanPrevision> getBilanPrevisionById(@PathVariable Long id) {
        BilanPrevision bilanPrevision = bilanPrevisionService.getBilanPrevisionById(id);
        if (bilanPrevision != null) {
            return new ResponseEntity<>(bilanPrevision, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // // Endpoint pour mettre à jour un bilan prévisionnel
    // @PutMapping("/update/{id}")
    // public ResponseEntity<BilanPrevision> updateBilanPrevision(@PathVariable Long id, @RequestBody BilanPrevision bilanPrevision) {
    //     BilanPrevision updatedBilanPrevision = bilanPrevisionService.updateBilanPrevision(id, bilanPrevision);
    //     if (updatedBilanPrevision != null) {
    //         return new ResponseEntity<>(updatedBilanPrevision, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // Endpoint pour supprimer un bilan prévisionnel
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBilanPrevision(@PathVariable Long id) {
        boolean isDeleted = bilanPrevisionService.deleteBilanPrevision(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
