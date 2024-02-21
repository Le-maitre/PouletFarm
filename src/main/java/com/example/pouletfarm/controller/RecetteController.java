package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.Recette;
import com.example.pouletfarm.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/recette")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    // Ajouter un nouvel enregistrement de poulet mort pour une entrée spécifique
    @PostMapping("/entree/{id}/add")
    public Recette addRecetteForEntree(@PathVariable Long id, @RequestBody Recette recette) {
        return recetteService.saveRecetteForEntree(id, recette);
    }

    // Supprimer un enregistrement de poulet mort par son ID pour une entrée spécifique
    @DeleteMapping("/entree/{entreeId}/delete/{id}")
    public void deleteRecetteForEntree(@PathVariable Long entreeId, @PathVariable Long id) {
        recetteService.deleteRecetteForEntree(entreeId, id);
    }
    
    // Récupérer les enregistrements de poulets morts pour une entrée spécifique
    @GetMapping("/entree/{id}")
    public List<Recette> getRecetteByEntreeId(@PathVariable Long id) {
        return recetteService.getRecetteByEntreeId(id);
    }
}
