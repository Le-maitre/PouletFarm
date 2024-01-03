package com.example.pouletfarm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bilanprevision")
public class BilanPrevision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_bilan")
    private String nom;

    @Column(name = "prix")
    private double prix;

    @Column(name = "description")
    private String description;

     @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "entree_id")
    private Entree entree;
}
