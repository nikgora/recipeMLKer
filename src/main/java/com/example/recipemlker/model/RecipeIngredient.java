package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe_ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ingredient_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_ingredient", referencedColumnName = "ingredient_id")
    @JsonIgnore
    private Ingredient  ingredient;
    @ManyToOne
    @JoinColumn(name = "fk_recipe", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;
    @Column (name = "amount_of_ingredient")
    private String amountOfIngredient;

}
