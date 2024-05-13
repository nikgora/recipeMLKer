package com.example.recipemlker.repository;

import com.example.recipemlker.model.UserReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReportRepository extends JpaRepository<UserReport, Long> {

    List<UserReport> findAllByIsAcceptedOrModeratorId(boolean accepted, Long moderator_id);
}
