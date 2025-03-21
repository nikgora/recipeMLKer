package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.CookingDevice;
import com.example.recipemlker.repository.DeviceRepository;
import com.example.recipemlker.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<CookingDevice> findAll() {
        return deviceRepository.findAll();
    }

}
