package com.example.pouletfarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pouletfarm.model.Forum;
import com.example.pouletfarm.model.Like;
import com.example.pouletfarm.model.User;
import com.example.pouletfarm.repository.LikeRepository;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public boolean userAimeForum(Long userId, Long forumId) {
        return likeRepository.existsByUserIdAndForumId(userId, forumId);
    }

    public void aimerForum(Long userId, Long forumId) {
        if (!userAimeForum(userId, forumId)) {
            Like like = new Like();
            User user = new User();
            user.setId(userId);
            Forum forum = new Forum();
            forum.setId(forumId);
    
            like.setCreateur(user);
            like.setForum(forum);
    
            likeRepository.save(like);
        }
    }
    
    public void unlikerForum(Long userId, Long forumId) {
        Like like = likeRepository.findByUserIdAndForumId(userId, forumId);
        if (like != null) {
            likeRepository.delete(like);
        }
    }

    public int nombreDeLikesPourForum(Long forumId) {
        return likeRepository.countByForumId(forumId);
    }
}
