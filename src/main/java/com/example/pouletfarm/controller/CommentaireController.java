package com.example.pouletfarm.controller;
import com.example.pouletfarm.model.Commentaire;

import com.example.pouletfarm.service.CommentaireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    // Endpoint pour récupérer tous les commentaires
    @GetMapping("/")
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireService.getAllCommentaires();
        return new ResponseEntity<>(commentaires, HttpStatus.OK);
    }

    // Endpoint pour récupérer un commentaire par ID
    @GetMapping("/{commentaireId}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long commentaireId) {
        Optional<Commentaire> commentaire = commentaireService.getCommentaireById(commentaireId);
        return commentaire.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour créer un nouveau commentaire
    @PostMapping("/")
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire newCommentaire = commentaireService.saveCommentaire(commentaire);
        return new ResponseEntity<>(newCommentaire, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour les détails d'un commentaire
    @PutMapping("/{commentaireId}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long commentaireId, @RequestBody Commentaire commentaire) {
        commentaire.setId(commentaireId); // Assure que l'ID du commentaire est défini
        Commentaire updatedCommentaire = commentaireService.updateCommentaire(commentaire);
        return new ResponseEntity<>(updatedCommentaire, HttpStatus.OK);
    }

    // Endpoint pour supprimer un commentaire par ID
    @DeleteMapping("/{commentaireId}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long commentaireId) {
        commentaireService.deleteCommentaireById(commentaireId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Autres endpoints personnalisés si nécessaires
}

