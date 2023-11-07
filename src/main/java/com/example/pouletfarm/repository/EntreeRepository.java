package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.Entree;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EntreeRepository extends JpaRepository<Entree, Long> {

    List<Entree> findByUserId(Long userId);

    Optional<Entree> findByIdAndUserId(Long id, Long userId);
}