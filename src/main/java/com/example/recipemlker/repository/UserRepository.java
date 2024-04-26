package com.example.recipemlker.repository;

import com.example.recipemlker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstById(long id);

    User findFirstByLogin(String username);
}
