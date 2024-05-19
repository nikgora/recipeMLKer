package com.example.recipemlker.repository;

import com.example.recipemlker.model.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    Moderator getById(long id);
}
