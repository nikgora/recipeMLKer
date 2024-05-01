package com.example.recipemlker.service;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category getCategoryByTitle(String title) {
        return categoryRepository.findFirstByTitle(title);
    }
}
