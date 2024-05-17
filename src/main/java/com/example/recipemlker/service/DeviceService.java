package com.example.recipemlker.service;

import com.example.recipemlker.model.CookingDevice;

import java.util.List;

public interface DeviceService {
    List<CookingDevice> findAll();
}
