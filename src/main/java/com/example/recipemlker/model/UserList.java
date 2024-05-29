package com.example.recipemlker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
    private User user;
    @OneToMany(mappedBy = "userList")
    private List<RecipeUserList> recipeUserLists;

    @Override
    public String toString() {
        return "UserList{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
