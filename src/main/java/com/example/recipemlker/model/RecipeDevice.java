package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe_device")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_device_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_device", referencedColumnName = "device_id")
    @JsonIgnore
    private CookingDevice  cookingDevice;
    @ManyToOne
    @JoinColumn(name = "fk_recipe", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;
}
