package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.AiReport;
import com.example.recipemlker.repository.AIReportRepository;
import com.example.recipemlker.service.AiReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiReportServiceImpl implements AiReportService {

    @Autowired
    private AIReportRepository aIReportRepository;

    @Override
    public List<AiReport> findAvailableForModer(boolean accepted, Long id) {
        return aIReportRepository.findAllByIsAcceptedOrModeratorId(accepted, id);
    }
}
