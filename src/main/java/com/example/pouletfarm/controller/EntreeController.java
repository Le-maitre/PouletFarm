package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.service.EntreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users") // Définir le chemin de base pour les requêtes liées à User
public class EntreeController {

    @Autowired
    private EntreeService entreeService;

    // Récupérer toutes les entrées pour un utilisateur spécifique
    @GetMapping("/{userId}/entrees/all")
    public List<Entree> getAllEntreesForUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return entreeService.getAllEntreesForUser(user);
    }

    // Récupérer une entrée par son ID pour un utilisateur spécifique
    @GetMapping("/{userId}/entrees/{id}")
    public ResponseEntity<Entree> getEntreeByIdForUser(@PathVariable Long userId, @PathVariable Long id) {
        User user = new User();
        user.setId(userId);
        Optional<Entree> entree = entreeService.getEntreeByIdForUser(id, user);
        return entree.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Créer une nouvelle entrée pour un utilisateur spécifique
    @PostMapping("/{userId}/entrees/create")
    public ResponseEntity<Entree> createEntreeForUser(@PathVariable Long userId, @RequestBody Entree entree) {
        User user = new User();
        user.setId(userId);
        Entree createdEntree = entreeService.createEntreeForUser(entree, user);
        return new ResponseEntity<>(createdEntree, HttpStatus.CREATED);
    }

    // Mettre à jour une entrée existante pour un utilisateur spécifique
   @PutMapping("/{userId}/entrees/{id}")
   public ResponseEntity<Entree> updateEntryForUser(@PathVariable Long userId, @PathVariable Long id, @RequestBody Entree updatedEntry) {
       Entree updatedEntree = entreeService.updateEntryForUser(id, updatedEntry, userId);
       return new ResponseEntity<>(updatedEntree, HttpStatus.OK);
   }

    // Supprimer une entrée par son ID pour un utilisateur spécifique
    @DeleteMapping("/{userId}/entrees/{id}")
    public ResponseEntity<Void> deleteEntreeForUser(@PathVariable Long userId, @PathVariable Long id) {
        User user = new User();
        user.setId(userId);
        entreeService.deleteEntreeForUser(id, user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
