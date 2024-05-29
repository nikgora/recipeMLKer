package com.example.recipemlker.repository;

import com.example.recipemlker.model.RecipeDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDeviceRepository extends JpaRepository<RecipeDevice, Long> {
}
