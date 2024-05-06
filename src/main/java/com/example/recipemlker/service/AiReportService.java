package com.example.recipemlker.service;

import com.example.recipemlker.model.AiReport;

import java.util.List;

public interface AiReportService {
    List<AiReport> findAvailableForModer(boolean accepted, Long id);
}
