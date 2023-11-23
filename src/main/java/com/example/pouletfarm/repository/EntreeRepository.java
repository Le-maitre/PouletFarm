package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.Entree;
import com.example.pouletfarm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntreeRepository extends JpaRepository<Entree, Long> {
    List<Entree> findByUser(User user);

    Optional<Entree> findByIdAndUser(Long id, User user);
    Optional<Entree> findByIdAndUserId(Long entryId, Long userId);
    void deleteByIdAndUser(Long id, User user);
}
