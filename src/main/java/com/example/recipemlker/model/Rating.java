package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rating")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_user",referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "fk_recipe", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;
    @Column(name = "mark")
    private Double mark;
}
