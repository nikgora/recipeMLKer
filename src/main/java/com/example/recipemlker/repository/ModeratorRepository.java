package com.example.recipemlker.repository;

import com.example.recipemlker.model.Moderator;
import com.example.recipemlker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    Moderator getFirstById(Long id);

    boolean existsByUser(User user);
}
