package com.example.recipemlker.service;

import com.example.recipemlker.model.CookingDevice;

import java.util.List;

public interface DeviceService {
    List<CookingDevice> findAll();

    boolean existsByName(String name);

    void save(CookingDevice device);

    CookingDevice getFirstByName(String deviceName);

}
