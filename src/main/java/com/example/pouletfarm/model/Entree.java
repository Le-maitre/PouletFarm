package com.example.pouletfarm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "entree")
public class Entree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_entree")
    private String dateEntree;

    @Column(name = "date_sortie")
    private String dateSortie;

    @Column(name = "nombre_poussins")
    private int nombrePoussins;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
     @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<Nourriture> nourritures;

     @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<BilanPrevision> bilansPrevision;

    @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<Alerte> alertes;

    @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<Rapport> rapports;

    @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<PouletMort> pouletsMorts;

    @OneToMany(mappedBy = "entree", cascade = CascadeType.ALL)
    private List<Vitamine> vitamines;
}
