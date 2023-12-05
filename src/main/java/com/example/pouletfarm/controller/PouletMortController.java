package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.PouletMort;
import com.example.pouletfarm.service.PouletMortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/pouletmort")
public class PouletMortController {

    @Autowired
    private PouletMortService pouletMortService;

    // Ajouter un nouvel enregistrement de poulet mort pour une entrée spécifique
    @PostMapping("/entree/{id}/add")
    public PouletMort addPouletMortForEntree(@PathVariable Long id, @RequestBody PouletMort pouletMort) {
        return pouletMortService.savePouletMortForEntree(id, pouletMort);
    }

    // Supprimer un enregistrement de poulet mort par son ID pour une entrée spécifique
    @DeleteMapping("/entree/{entreeId}/delete/{id}")
    public void deletePouletMortForEntree(@PathVariable Long entreeId, @PathVariable Long id) {
        pouletMortService.deletePouletMortForEntree(entreeId, id);
    }
    
    // Récupérer les enregistrements de poulets morts pour une entrée spécifique
    @GetMapping("/entree/{id}")
    public List<PouletMort> getPouletMortsByEntreeId(@PathVariable Long id) {
        return pouletMortService.getPouletMortsByEntreeId(id);
    }
}
