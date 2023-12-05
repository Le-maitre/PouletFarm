package com.example.pouletfarm.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Event {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "date_event")
    private LocalDate dateEvent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }
    public LocalDate getDateEvent() {
        return this.dateEvent;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
     public String getNom() {
        return this.nom;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

