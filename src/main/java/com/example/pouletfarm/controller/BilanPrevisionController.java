package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.BilanPrevision;
import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.service.BilanPrevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bilanprevisions")
public class BilanPrevisionController {

    private final BilanPrevisionService bilanPrevisionService;

    // Constructeur
    public BilanPrevisionController(BilanPrevisionService bilanPrevisionService) {
        this.bilanPrevisionService = bilanPrevisionService;
    }

    // Récupérer tous les bilans prévisionnels associés à une entree spécifique
    @GetMapping("/entree/{entreeId}")
    public List<BilanPrevision> getBilanPrevisionsByEntree(@PathVariable Long entreeId) {
        Entree entree = new Entree();
        entree.setId(entreeId);
        return bilanPrevisionService.getBilanPrevisionsByEntree(entree);
    }

    // Récupérer un bilan prévisionnel par son ID
    @GetMapping("/{id}")
    public ResponseEntity<BilanPrevision> getBilanPrevisionById(@PathVariable Long id) {
        Optional<BilanPrevision> bilanPrevision = bilanPrevisionService.getBilanPrevisionById(id);
        return bilanPrevision.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Créer un nouveau bilan prévisionnel associé à une entree
    @PostMapping("/entree/{entreeId}")
    public ResponseEntity<BilanPrevision> createBilanPrevision(@PathVariable Long entreeId, @RequestBody BilanPrevision bilanPrevision) {
        Entree entree = new Entree();
        entree.setId(entreeId);
        bilanPrevision.setEntree(entree);

        BilanPrevision createdBilanPrevision = bilanPrevisionService.createBilanPrevision(bilanPrevision);
        return new ResponseEntity<>(createdBilanPrevision, HttpStatus.CREATED);
    }

    // Mettre à jour un bilan prévisionnel existant
    @PutMapping("/{id}")
    public ResponseEntity<BilanPrevision> updateBilanPrevision(@PathVariable Long id, @RequestBody BilanPrevision bilanPrevision) {
        BilanPrevision updatedBilanPrevision = bilanPrevisionService.updateBilanPrevision(id, bilanPrevision);
        if (updatedBilanPrevision != null) {
            return new ResponseEntity<>(updatedBilanPrevision, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un bilan prévisionnel par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilanPrevision(@PathVariable Long id) {
        bilanPrevisionService.deleteBilanPrevision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
