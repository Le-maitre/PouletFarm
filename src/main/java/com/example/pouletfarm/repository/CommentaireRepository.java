package com.example.pouletfarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pouletfarm.model.Commentaire;
@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{
    
}
