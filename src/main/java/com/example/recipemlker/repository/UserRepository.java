package com.example.recipemlker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.recipemlker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstById(long id);
}
