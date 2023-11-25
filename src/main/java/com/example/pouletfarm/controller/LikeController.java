package com.example.pouletfarm.controller;
import com.example.pouletfarm.model.Like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.example.pouletfarm.service.LikeService;
@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    // Endpoint pour récupérer tous les likes
    @GetMapping("/")
    public ResponseEntity<List<Like>> getAllLikes() {
        List<Like> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    // Endpoint pour récupérer un like par ID
    @GetMapping("/{likeId}")
    public ResponseEntity<Like> getLikeById(@PathVariable Long likeId) {
        Optional<Like> like = likeService.getLikeById(likeId);
        return like.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour créer un nouveau like
    @PostMapping("/")
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like newLike = likeService.saveLike(like);
        return new ResponseEntity<>(newLike, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour les détails d'un like
    @PutMapping("/{likeId}")
    public ResponseEntity<Like> updateLike(@PathVariable Long likeId, @RequestBody Like like) {
        like.setId(likeId); // Assure que l'ID du like est défini
        Like updatedLike = likeService.updateLike(like);
        return new ResponseEntity<>(updatedLike, HttpStatus.OK);
    }

    // Endpoint pour supprimer un like par ID
    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long likeId) {
        likeService.deleteLikeById(likeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
