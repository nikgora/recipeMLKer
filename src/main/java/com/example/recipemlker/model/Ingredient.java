package com.example.recipemlker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;
    @Column(name = "title")
    private String name;
    @Column (name = "allergen")
    private boolean isAllergen;
    @OneToMany(mappedBy = "ingredient")
    private List<RecipeIngredient> recipeIngredients;

}
