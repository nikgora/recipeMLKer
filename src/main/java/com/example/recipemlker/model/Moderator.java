package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "moderator")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Moderator {
    @Transient
    String role = "ADMIN";
    @Column(name = "secret_password")
    private String secret_password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moderator_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "moderator")
    private List<AiReport> aiReports;
    @OneToMany(mappedBy = "moderator")
    private List<UserReport> userReports;

    @Override
    public String toString() {
        return "Moderator{" +
                "role='" + role + '\'' +
                ", secret_password='" + secret_password + '\'' +
                ", id=" + id +
                '}';
    }
}
