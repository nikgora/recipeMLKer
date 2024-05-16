package com.example.recipemlker.service;

import com.example.recipemlker.model.UserReport;

import java.util.List;

public interface UserReportService {
    List<UserReport> findAvailableForModer(boolean accepted, Long id);
    void save(UserReport userReport);
}
