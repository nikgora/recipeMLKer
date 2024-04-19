package com.example.recipemlker.model;

import jakarta.persistence.*;

@Entity
@Table (name = "publishedrecipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "cooking_time")
    private String cookingTime;
    @Column(name = "is_published")
    private boolean is_published;
    @Column(name = "fk_user")
    private Long fk_user;
    @Column(name = "fk_category")
    private Long fk_category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isIs_published() {
        return is_published;
    }

    public void setIs_published(boolean is_published) {
        this.is_published = is_published;
    }

    public Long getFk_user() {
        return fk_user;
    }

    public void setFk_user(Long fk_user) {
        this.fk_user = fk_user;
    }

    public Long getFk_category() {
        return fk_category;
    }

    public void setFk_category(Long fk_category) {
        this.fk_category = fk_category;
    }
}
