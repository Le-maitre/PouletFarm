package com.example.pouletfarm.model;

import java.util.List;

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

    @Column(name = "date_entree")
    private String dateEntree;

    @Column(name = "nombre_poussins")
    private int nombrePoussins;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "entree")
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "entree")
    private List<Nourriture> nourritures;

    @OneToMany(mappedBy = "entree")
    private List<BilanPrevision> bilansPrevision;

    @OneToMany(mappedBy = "entree")
    private List<Alerte> alertes;

    @OneToMany(mappedBy = "entree")
    private List<Rapport> rapports;

    @OneToMany(mappedBy = "entree")
    private List<PouletMort> pouletsMorts;

    @OneToMany(mappedBy = "entree")
    private List<Vitamine> vitamines;
}
