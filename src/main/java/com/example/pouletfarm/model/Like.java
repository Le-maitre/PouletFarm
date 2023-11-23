package com.example.pouletfarm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "likee")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Forum forum;
      @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; 

    public void setCreateur(User user) {
        this.user = user;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
