package com.example.recipemlker.model;

import jakarta.persistence.*;

@Entity
@Table (name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public boolean isAllergen() {
        return isAllergen;
    }

    public void setAllergen(boolean allergen) {
        isAllergen = allergen;
    }

    private boolean isAllergen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
