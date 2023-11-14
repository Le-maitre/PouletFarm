package com.example.pouletfarm.repository;

import com.example.pouletfarm.model.TacheBilan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheBilanRepository extends JpaRepository<TacheBilan, Long> {
    List<TacheBilan> findAllByBilanPrevisionId(Long bilanPrevisionId);
}
