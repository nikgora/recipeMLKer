package com.example.recipemlker.service.impl;

import com.example.recipemlker.model.UserReport;
import com.example.recipemlker.repository.UserReportRepository;
import com.example.recipemlker.service.UserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReportServiceImpl implements UserReportService {

    @Autowired
    private UserReportRepository userReportRepository;

    @Override
    public List<UserReport> findAvailableForModer(boolean accepted, Long id) {
        return userReportRepository.findAllByIsAcceptedOrModeratorId(accepted, id);
    }

    @Override
    public void save(UserReport userReport) {
        userReportRepository.save(userReport);
    }
}
