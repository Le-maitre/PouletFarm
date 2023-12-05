package com.example.pouletfarm.model;

import java.sql.Date;

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
@Table(name = "pouletmort")
public class PouletMort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cause_deces")
    private String causeDeces;

    @Column(name = "date_perte") 
    private Date datePerte;

    @Column(name = "nombre")
    private int nombre;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "entree_id")
    private Entree entree; 
}
