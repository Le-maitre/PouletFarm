package com.example.pouletfarm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pouletfarm.model.Forum;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.ForumRepository;
import com.example.pouletfarm.repository.UserRepository;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private UserRepository userRepository;

    // Méthode pour trouver un forum par ID
    public Optional<Forum> getForumById(Long forumId) {
        return forumRepository.findById(forumId);
    }

    // Méthode pour trouver tous les forums
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    // Méthode pour enregistrer un nouveau forum
    public Forum createForum(Long userId, Forum newForum) {
        // Récupérer l'utilisateur à partir de l'ID
        Optional<User> userOptional = userRepository.findById(userId);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
            // Associer le forum à l'utilisateur
            newForum.setUser(user);
              // Sauvegarder le forum
              return forumRepository.save(newForum);
            } else {
                // Gérer le cas où l'utilisateur n'est pas trouvé
                // Peut-être lancer une exception ou retourner null selon la logique de votre application
                return null;
            }
        }

    // Méthode pour mettre à jour les détails du forum
    public Forum updateForum(Forum forum) {
        return forumRepository.save(forum);
    }

    // Méthode pour supprimer un forum par ID
    public void deleteForumById(Long forumId) {
        forumRepository.deleteById(forumId);
    }
    
    // Autres méthodes personnalisées si nécessaires
}

