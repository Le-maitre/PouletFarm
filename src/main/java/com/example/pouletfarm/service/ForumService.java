package com.example.pouletfarm.service;

import com.example.pouletfarm.model.Forum;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ForumService {

    private final ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public Forum createForum(Forum forum, MultipartFile fichierAttache, Optional<User> userOptional) throws Exception {
        if (forumRepository.findByDescription(forum.getDescription()) == null) {
            if (fichierAttache != null) {
                String location = "C:\\xampp\\htdocs\\pouletfarm";
                Path rootLocation = Paths.get(location);
    
                try {
                    if (!Files.exists(rootLocation)) {
                        Files.createDirectories(rootLocation);
                    }
    
                    String nomFichier = location + "\\" + fichierAttache.getOriginalFilename();
                    Path filePath = Paths.get(nomFichier);
    
                    if (Files.exists(filePath)) {
                        Files.delete(filePath);
                    }
    
                    Files.copy(fichierAttache.getInputStream(), rootLocation.resolve(fichierAttache.getOriginalFilename()));
                    forum.setImageUrl("http://localhost/pouletfarm/" + fichierAttache.getOriginalFilename());
                } catch (Exception e) {
                    throw new Exception("Une erreur s'est produite lors de la manipulation du fichier");
                }
            }
    
            User user = userOptional.orElseThrow(() -> new IllegalArgumentException("L'utilisateur est obligatoire pour créer un forum"));
            forum.setUser(user); // Associer l'utilisateur à la publication du forum
    
            return forumRepository.save(forum);
        } else {
            throw new IllegalArgumentException("Le forum existe déjà");
        }
    }
    

    public Forum getForumById(Long id) {
        return forumRepository.findById(id).orElse(null);
    }

    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    public Forum updateForum(Forum forum) {
        return forumRepository.save(forum);
    }

    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }
}
