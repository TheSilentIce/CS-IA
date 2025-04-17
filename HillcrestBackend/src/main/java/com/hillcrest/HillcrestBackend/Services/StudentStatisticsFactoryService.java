package com.hillcrest.HillcrestBackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Factory service for handling statistics for different student types
 * Allows for easy extension when adding new student types
 */
@Service
public class StudentStatisticsFactoryService {

    private final StudentStatisticsService statisticsService;

    @Autowired
    public StudentStatisticsFactoryService(StudentStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    /**
     * Get statistics for any student type
     * @param studentType - Type of student
     * @return DTO with appropriate statistics
     */
    public StatisticsResponseDTO getStatisticsForType(String studentType) {
        StatisticsResponseDTO response = new StatisticsResponseDTO(studentType);

        // Always include general statistics
        Map<String, Double> generalStats = statisticsService.getGeneralStatistics(studentType);
        response.setGeneralStatistics(generalStats);

        // Based on type, add type-specific statistics
        switch(studentType.toUpperCase()) {
            case "BUSINESS":
                Map<String, Double> businessStats = statisticsService.getBusinessStatistics();
                response.setTypeSpecificStatistics(businessStats);
                break;

            case "MEDICAL":
                Map<String, Double> medicalStats = statisticsService.getMedicalStatistics();
                response.setTypeSpecificStatistics(medicalStats);
                break;

            case "ENGINEERING":
                Map<String, Double> engineeringStats = statisticsService.getEngineeringStatistics();
                response.setTypeSpecificStatistics(engineeringStats);
                break;

            case "OTHER":
                // Other students don't have specific attributes
                response.setTypeSpecificStatistics(Map.of());
                break;

            case "ALL":
                // No specific statistics for ALL
                response.setTypeSpecificStatistics(Map.of());
                break;

            default:
                // Unknown type, only return general statistics
                response.setTypeSpecificStatistics(Map.of());
                break;
        }

        return response;
    }
}