package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userreport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;
    @Column(name = "is_accepted")
    private Boolean isAccepted;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_moderator", referencedColumnName = "moderator_id")
    @JsonIgnore
    private Moderator moderator;
    @ManyToOne
    @JoinColumn(name = "fk_publishedrecipe_id", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "UserReport{" +
                "description='" + description + '\'' +
                ", isAccepted=" + isAccepted +
                ", id=" + id +
                '}';
    }
}
