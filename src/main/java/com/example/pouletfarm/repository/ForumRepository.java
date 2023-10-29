package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pouletfarm.model.Forum;

public interface ForumRepository extends JpaRepository<Forum, Long>  {
    
}
