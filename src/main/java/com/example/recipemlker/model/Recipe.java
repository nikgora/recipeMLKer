package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "publishedrecipe")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "cooking_time")
    private String cookingTime;
    @Column(name = "published")
    private boolean isPublished;
    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "fk_category", referencedColumnName = "category_id")
    @JsonIgnore
    private Category category;
    @OneToMany (mappedBy = "recipe")
    private List<AiReport> aiReports;
    @OneToMany (mappedBy = "recipe")
    private List<Comment> comments;
    @OneToMany (mappedBy = "recipe")
    private List<Rating> ratings;
    @OneToMany (mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients;
    @OneToMany (mappedBy = "recipe")
    private List<RecipeDevice> recipeDevices;

}
