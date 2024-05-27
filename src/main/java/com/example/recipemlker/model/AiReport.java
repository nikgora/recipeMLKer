package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "aireport")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AiReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;
    @Column (name = "description")
    private String description;
    @Column(name = "is_accepted")
    private boolean isAccepted;
    @ManyToOne
    @JoinColumn(name = "fk_moderator", referencedColumnName = "moderator_id")
    @JsonIgnore
    private Moderator moderator;
    @ManyToOne
    @JoinColumn(name = "fk_recipe", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;
}
