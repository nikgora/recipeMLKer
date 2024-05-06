package com.example.recipemlker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Transient
    String role = "ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToOne(mappedBy = "user")
    private Moderator moderator;
    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;
    @OneToMany(mappedBy = "user")
    private List<UserList> userLists;
    @OneToMany(mappedBy = "user")
    private List<UserReport> userReports;

}
