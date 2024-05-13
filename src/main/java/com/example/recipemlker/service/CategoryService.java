package com.example.recipemlker.service;

import com.example.recipemlker.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryByTitle(String title);

    Category getCategoryById(Long id);

    List<String> getAllCategory();
}
