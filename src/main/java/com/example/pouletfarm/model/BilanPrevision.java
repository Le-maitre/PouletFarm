package com.example.pouletfarm.model;

import java.sql.Date;

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

    @Column(name = "date_bilan")
    private Date dateBilan;

    @Column(name = "cout_estime")
    private double coutEstime;

    @Column(name = "revenu_attendu")
    private double revenuAttendu;

    @Column(name = "benefice_attendu")
    private double beneficeAttendu;

    @ManyToOne
    @JoinColumn(name = "entree_id")
    private Entree entree;
}
