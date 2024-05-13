package com.example.recipemlker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="fk_user", referencedColumnName = "user_id")
    private User user;

}
