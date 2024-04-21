package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeDevice {
    @OneToOne
    @JoinColumn(name = "fk_ingredient")
    @JsonIgnore
    private Ingredient  ingredient;
    @OneToOne
    @JoinColumn(name = "fk_recipe")
    @JsonIgnore
    private Recipe recipe;
    @Column (name = "amount_of_ingredient")
    private String amountOfIngredient;
}
