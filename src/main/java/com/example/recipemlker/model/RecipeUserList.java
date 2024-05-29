package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe_userlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeUserList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_userlist_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_user_list", referencedColumnName = "list_id")
    @JsonIgnore
    private UserList userList;
    @ManyToOne
    @JoinColumn(name = "fk_recipe_id", referencedColumnName = "recipe_id")
    @JsonIgnore
    private Recipe recipe;

    @Override
    public String toString() {
        return "RecipeUserList{" +
                "id=" + id +
                '}';
    }
}
