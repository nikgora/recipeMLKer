package com.example.recipemlker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "moderator")
public class Moderator {
    @Column(name = "secret_password")
    private String secret_password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moderator_id;
    @OneToOne
    @JoinColumn(name = "fk_user")
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSecret_password() {
        return secret_password;
    }

    public void setSecret_password(String secret_password) {
        this.secret_password = secret_password;
    }

    public void setModerator_id(Long moderatorId) {
        this.moderator_id = moderatorId;
    }

    public Long getModerator_id() {
        return moderator_id;
    }
}
