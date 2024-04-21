package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;
    @OneToOne
    @JoinColumn(name = "fk_user")
    @JsonIgnore
    private User user;
    @OneToOne
    @JoinColumn(name = "fk_recipe")
    @JsonIgnore
    private Recipe recipe;

}
