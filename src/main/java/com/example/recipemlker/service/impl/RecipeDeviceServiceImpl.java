package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.RecipeDevice;
import com.example.recipemlker.repository.RecipeDeviceRepository;
import com.example.recipemlker.service.RecipeDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeDeviceServiceImpl implements RecipeDeviceService {
    @Autowired
    private RecipeDeviceRepository recipeDeviceRepository;

    @Override
    public RecipeDevice save(RecipeDevice recipeDevice) {
        return recipeDeviceRepository.save(recipeDevice);
    }

}
