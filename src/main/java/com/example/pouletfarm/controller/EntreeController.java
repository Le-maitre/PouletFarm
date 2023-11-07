package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.service.EntreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/entree")
public class EntreeController {

    @Autowired
    private EntreeService entreeService;

    @PostMapping("/create")
    public ResponseEntity<Entree> createEntree(@RequestBody Entree entree, @PathVariable Long userId) {
        Entree newEntree = entreeService.createEntree(entree, userId);
        return new ResponseEntity<>(newEntree, HttpStatus.CREATED);
    }    

    @GetMapping("/all")
    public ResponseEntity<List<Entree>> getAllEntrees(@PathVariable Long userId) {
        List<Entree> entrees = entreeService.getAllEntrees(userId);
        return new ResponseEntity<>(entrees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entree> getEntreeById(@PathVariable Long userId, @PathVariable Long id) {
        Entree entree = entreeService.getEntreeById(id, userId);
        if (entree != null) {
            return new ResponseEntity<>(entree, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Entree> updateEntree(@PathVariable Long userId, @PathVariable Long id, @RequestBody Entree entree) {
        Entree updatedEntree = entreeService.updateEntree(id, entree, userId);
        if (updatedEntree != null) {
            return new ResponseEntity<>(updatedEntree, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntree(@PathVariable Long userId, @PathVariable Long id) {
        boolean isDeleted = entreeService.deleteEntree(id, userId);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
