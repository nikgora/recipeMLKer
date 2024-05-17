package com.example.recipemlker.repository;

import com.example.recipemlker.model.User;
import com.example.recipemlker.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserListRepository extends JpaRepository<UserList, Long> {
    UserList getFirstByTitleAndUser(String title, User user);
}
