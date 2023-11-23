package com.example.pouletfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pouletfarm.model.Forum;
import com.example.pouletfarm.repository.ForumRepository;

public class ForumService {
     @Autowired
    private ForumRepository forumRepository;

    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    public Forum getForumById(Long id) {
        return forumRepository.findById(id).orElse(null);
    }

    public Forum createForum(Forum forum) {
        return forumRepository.save(forum);
    }
}
