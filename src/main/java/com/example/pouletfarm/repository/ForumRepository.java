package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pouletfarm.model.Forum;
@Repository
public interface ForumRepository extends JpaRepository<Forum, Long>  {
    Forum findByDescription(String description);
}
