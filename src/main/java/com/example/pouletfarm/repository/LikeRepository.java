package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pouletfarm.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserIdAndForumId(Long userId, Long forumId);
    Like findByUserIdAndForumId(Long userId, Long forumId);
    int countByForumId(Long forumId);
}
