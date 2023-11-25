package com.example.pouletfarm.controller;


import com.example.pouletfarm.model.Forum;
import com.example.pouletfarm.service.ForumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/forums")
public class ForumController {

    @Autowired
    private ForumService forumService;

    // Endpoint pour récupérer tous les forums
    @GetMapping("/all")
    public ResponseEntity<List<Forum>> getAllForums() {
        List<Forum> forums = forumService.getAllForums();
        return new ResponseEntity<>(forums, HttpStatus.OK);
    }

    // Endpoint pour récupérer un forum par ID
    @GetMapping("/{forumId}")
    public ResponseEntity<Forum> getForumById(@PathVariable Long forumId) {
        Optional<Forum> forum = forumService.getForumById(forumId);
        return forum.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

     // Endpoint pour ajouter un nouveau forum
     @PostMapping("/")
     public ResponseEntity<Forum> createForum(@RequestBody Forum newForum) {
         // Supposons que vous récupérez l'ID de l'utilisateur à partir de newForum ou d'une autre source
         Long userId = newForum.getUserId(); // Assurez-vous de récupérer correctement l'ID de l'utilisateur
     
         // Ajouter d'autres logiques/validation si nécessaire avant d'ajouter le forum
         Forum createdForum = forumService.createForum(userId, newForum);
         return new ResponseEntity<>(createdForum, HttpStatus.CREATED);
     }
     

    // Endpoint pour mettre à jour les détails d'un forum
    @PutMapping("/{forumId}")
    public ResponseEntity<Forum> updateForum(@PathVariable Long forumId, @RequestBody Forum forum) {
        forum.setId(forumId); // Assure que l'ID du forum est défini
        Forum updatedForum = forumService.updateForum(forum);
        return new ResponseEntity<>(updatedForum, HttpStatus.OK);
    }

    // Endpoint pour supprimer un forum par ID
    @DeleteMapping("/{forumId}")
    public ResponseEntity<Void> deleteForum(@PathVariable Long forumId) {
        forumService.deleteForumById(forumId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Autres endpoints personnalisés si nécessaires
}
