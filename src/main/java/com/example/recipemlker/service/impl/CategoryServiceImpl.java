package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.Category;
import com.example.recipemlker.repository.CategoryRepository;
import com.example.recipemlker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategoryByTitle(String title) {
        return categoryRepository.findFirstByTitle(title);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findFirstById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategories();
    }
}
