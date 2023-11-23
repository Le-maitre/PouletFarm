package com.example.pouletfarm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "forum")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob // Utilisation de @Lob pour stocker des données binaires (comme une image)
    @Column(columnDefinition = "BLOB")
    private byte[] photo;

    private String description;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id") // Assurez-vous que le nom de la colonne correspond à votre base de données
    private User user;
}
