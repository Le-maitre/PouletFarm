package com.example.pouletfarm.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String imageUrl; // Lien URL de l'image
    
    // Relations avec d'autres entités
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy = "forum")
    private List<Commentaire> commentaires;
       
    
    @OneToMany(mappedBy = "forum")
    private List<Like> likes;
    
    public Long getUserId() {
        return this.user != null ? this.user.getId() : null;
    }
}
