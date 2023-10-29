package com.example.pouletfarm.controller;

import com.example.pouletfarm.model.PouletMort;
import com.example.pouletfarm.service.PouletMortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pouletmort")
public class PouletMortController {

    @Autowired
    private PouletMortService pouletMortService;

    // Récupérer tous les enregistrements de poulets morts
    @GetMapping("/all")
    public List<PouletMort> getAllPouletMorts() {
        return pouletMortService.getAllPouletsMorts();
    }

    // Récupérer un enregistrement de poulet mort par son ID
    @GetMapping("/{id}")
    public PouletMort getPouletMortById(@PathVariable Long id) {
        return pouletMortService.getPouletMortById(id).orElse(null);
    }

    // Ajouter un nouvel enregistrement de poulet mort
    @PostMapping("/add")
    public PouletMort addPouletMort(@RequestBody PouletMort pouletMort) {
        return pouletMortService.savePouletMort(pouletMort);
    }

    // Supprimer un enregistrement de poulet mort par son ID
    @DeleteMapping("/delete/{id}")
    public void deletePouletMort(@PathVariable Long id) {
        pouletMortService.deletePouletMort(id);
    }
}
