package com.example.recipemlker.repository;

import com.example.recipemlker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findFirstByTitle(String title);

    Category findFirstById(Long id);

    @Query(value = "select c.title from Category c")
    List<String> findAllCategories();
}
