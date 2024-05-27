package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.round;

@Entity
@Table(name = "publishedrecipe")
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
    private int cookingTime;
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
    @OneToMany(mappedBy = "recipe")
    private List<AiReport> aiReports;
    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;
    @OneToMany(mappedBy = "recipe")
    private List<Rating> ratings;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredient> recipeIngredients;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeDevice> recipeDevices;
    @OneToMany(mappedBy = "recipe")
    private List<UserReport> userReports;

    @Transient
    private double averageRating;
    @Transient
    private boolean rejected;
    @Transient
    private boolean onView;
    @Transient
    private boolean notClickedPublish;

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculateTransientFields() {
        this.averageRating = getAverageMark();
        this.rejected = (aiReports != null && !aiReports.isEmpty() && aiReports.get(0).isAccepted() && aiReports.get(0).getModerator() == null);
        this.onView = (aiReports != null && !aiReports.isEmpty() && (!aiReports.get(0).isAccepted() || aiReports.get(0).getModerator() != null));
        this.notClickedPublish = (aiReports == null || aiReports.isEmpty());
    }

    @Transient
    public double getAverageMark() {
        if (ratings == null || ratings.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getMark();
        }
        return round(sum / ratings.size(), 1);
    }

}