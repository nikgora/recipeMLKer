package com.example.recipemlker.repository;

import com.example.recipemlker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstById(long id);

    boolean existsByLogin(String login);

    Optional<User> findByLogin(String username);
}
