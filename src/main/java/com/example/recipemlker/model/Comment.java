package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "fk_recipe", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }
}
