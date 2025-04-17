package com.hillcrest.HillcrestBackend.Services;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Data Transfer Object for student statistics responses
 */
@Setter
@Getter
public class StatisticsResponseDTO {
    private Map<String, Double> generalStatistics;
    private Map<String, Double> typeSpecificStatistics;
    private String studentType;

    public StatisticsResponseDTO() {
        this.generalStatistics = new HashMap<>();
        this.typeSpecificStatistics = new HashMap<>();
    }

    public StatisticsResponseDTO(String studentType) {
        this();
        this.studentType = studentType;
    }

    public void addGeneralStatistic(String key, Double value) {
        this.generalStatistics.put(key, value);
    }

    public void addTypeSpecificStatistic(String key, Double value) {
        this.typeSpecificStatistics.put(key, value);
    }
}