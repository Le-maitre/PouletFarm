package com.example.pouletfarm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pouletfarm.model.Commentaire;
import com.example.pouletfarm.repository.CommentaireRepository;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    // Méthode pour trouver un commentaire par ID
    public Optional<Commentaire> getCommentaireById(Long commentaireId) {
        return commentaireRepository.findById(commentaireId);
    }

    // Méthode pour trouver tous les commentaires
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    // Méthode pour enregistrer un nouveau commentaire
    public Commentaire saveCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    // Méthode pour mettre à jour les détails du commentaire
    public Commentaire updateCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    // Méthode pour supprimer un commentaire par ID
    public void deleteCommentaireById(Long commentaireId) {
        commentaireRepository.deleteById(commentaireId);
    }
}

