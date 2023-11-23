package com.example.pouletfarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.pouletfarm.service.LikeService;

@RestController
@RequestMapping("/api//likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/aimer")
    public void aimerForum(@RequestParam Long userId, @RequestParam Long forumId) {
        likeService.aimerForum(userId, forumId);
    }

    @DeleteMapping("/unliker")
    public void unlikerForum(@RequestParam Long userId, @RequestParam Long forumId) {
        likeService.unlikerForum(userId, forumId);
    }

    @GetMapping("/nombre-de-likes")
    public int nombreDeLikesPourForum(@RequestParam Long forumId) {
        return likeService.nombreDeLikesPourForum(forumId);
    }
}
