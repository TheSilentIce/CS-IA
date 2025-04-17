package com.hillcrest.HillcrestBackend.Controllers;

import com.hillcrest.HillcrestBackend.Services.StatisticsResponseDTO;
import com.hillcrest.HillcrestBackend.Services.StudentStatisticsService;
import com.hillcrest.HillcrestBackend.Services.StudentStatisticsFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST controller for retrieving student statistics
 */
@RestController
@RequestMapping("/api/statistics")
@CrossOrigin(origins = "*")
public class StudentStatisticsController {

    private final StudentStatisticsService statisticsService;
    private final StudentStatisticsFactoryService factoryService;

    @Autowired
    public StudentStatisticsController(
            StudentStatisticsService statisticsService,
            StudentStatisticsFactoryService factoryService) {
        this.statisticsService = statisticsService;
        this.factoryService = factoryService;
    }

    /**
     * Get combined statistics for a specific student type
     * @param studentType - Type of student (ALL, BUSINESS, etc.)
     * @return Combined general and type-specific statistics in a consistent DTO
     */
    @GetMapping("/getStatistics")
    public ResponseEntity<StatisticsResponseDTO> getStatistics(
            @RequestParam(required = false, defaultValue = "ALL") String studentType) {

        StatisticsResponseDTO response = factoryService.getStatisticsForType(studentType);

        return ResponseEntity.ok(response);
    }

    /**
     * Additional endpoint to ensure backward compatibility
     */
    @GetMapping
    public ResponseEntity<StatisticsResponseDTO> getStatisticsAlt(
            @RequestParam(required = false, defaultValue = "ALL") String studentType) {
        return getStatistics(studentType);
    }

    /**
     * Get only business-specific statistics
     * @return Map of business-specific attribute names to their percentages
     */
    @GetMapping("/business")
    public ResponseEntity<Map<String, Double>> getBusinessStatistics() {
        return ResponseEntity.ok(statisticsService.getBusinessStatistics());
    }

    /**
     * Get only engineering-specific statistics
     * @return Map of engineering-specific attribute names to their percentages
     */
    @GetMapping("/engineering")
    public ResponseEntity<Map<String, Double>> getEngineeringStatistics() {
        return ResponseEntity.ok(statisticsService.getEngineeringStatistics());
    }

    /**
     * Get only medical-specific statistics
     * @return Map of medical-specific attribute names to their percentages
     */
    @GetMapping("/medical")
    public ResponseEntity<Map<String, Double>> getMedicalStatistics() {
        return ResponseEntity.ok(statisticsService.getMedicalStatistics());
    }
}