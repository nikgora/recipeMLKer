package com.example.recipemlker.repository;

import com.example.recipemlker.model.AiReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AIReportRepository extends JpaRepository<AiReport, Long> {
    AiReport getFirstById(Long id);

    List<AiReport> findAllByIsAcceptedOrModeratorId(boolean accepted, Long moderator_id);
}
