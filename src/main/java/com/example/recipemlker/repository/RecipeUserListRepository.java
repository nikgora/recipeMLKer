package com.example.recipemlker.repository;

import com.example.recipemlker.model.RecipeUserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeUserListRepository extends JpaRepository<RecipeUserList, Long> {

}
