package com.example.recipemlker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes;
}
