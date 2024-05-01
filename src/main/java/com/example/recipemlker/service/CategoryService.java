package com.example.recipemlker.service;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface CategoryService {
    Category getCategoryByTitle(String title);
}
