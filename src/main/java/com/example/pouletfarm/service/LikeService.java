package com.example.pouletfarm.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pouletfarm.model.Like;
import com.example.pouletfarm.repository.LikeRepository;
@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    // Méthode pour trouver un like par ID
    public Optional<Like> getLikeById(Long likeId) {
        return likeRepository.findById(likeId);
    }

    // Méthode pour trouver tous les likes
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    // Méthode pour enregistrer un nouveau like
    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    // Méthode pour mettre à jour les détails du like
    public Like updateLike(Like like) {
        return likeRepository.save(like);
    }

    // Méthode pour supprimer un like par ID
    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
    
    // Autres méthodes personnalisées si nécessaires
}
