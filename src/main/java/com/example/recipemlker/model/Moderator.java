package com.example.recipemlker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moderator")
public class Moderator {
    @Column(name = "secret_password")
    private String secret_password;
    @Column(name = "fk_user")
    private Long fk_user;

    public String getSecret_password() {
        return secret_password;
    }

    public void setSecret_password(String secret_password) {
        this.secret_password = secret_password;
    }

    public Long getFk_user() {
        return fk_user;
    }

    public void setFk_user(Long fk_user) {
        this.fk_user = fk_user;
    }

    @Id
    private Long moderator_id;

    public void setModerator_id(Long moderatorId) {
        this.moderator_id = moderatorId;
    }

    public Long getModerator_id() {
        return moderator_id;
    }
}
