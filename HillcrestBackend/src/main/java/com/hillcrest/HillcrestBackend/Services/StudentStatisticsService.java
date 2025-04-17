package com.hillcrest.HillcrestBackend.Services;

import com.hillcrest.HillcrestBackend.Entities.BusinessStudent;
import com.hillcrest.HillcrestBackend.Entities.EngineeringStudent;
import com.hillcrest.HillcrestBackend.Entities.MedicalStudent;
import com.hillcrest.HillcrestBackend.Entities.Student;
import com.hillcrest.HillcrestBackend.Repositories.StudentRepository;
import com.hillcrest.HillcrestBackend.Repositories.StudentStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service to calculate statistics about students
 */
@Service
public class StudentStatisticsService {

    private final StudentRepository studentRepository;
    private final StudentStatisticsRepository statisticsRepository;

    @Autowired
    public StudentStatisticsService(StudentRepository studentRepository,
                                    StudentStatisticsRepository statisticsRepository) {
        this.studentRepository = studentRepository;
        this.statisticsRepository = statisticsRepository;
    }

    /**
     * Get general statistics for all students or a specific student type
     *
     * @param studentType - Optional student type filter (null for all students)
     * @return Map of attribute names to their percentages
     */
    public Map<String, Double> getGeneralStatistics(String studentType) {
        String typeParam = studentType != null && !studentType.equals("ALL") ?
                studentType.toUpperCase() : null;

        try {
            Map<String, Double> dbStatistics = statisticsRepository.getGeneralStatisticsPercentages(typeParam);

            Map<String, Double> statistics = new HashMap<>();
            statistics.put("hadLeadership", dbStatistics.getOrDefault("leadership_percentage", 0.0));
            statistics.put("hadVolunteering", dbStatistics.getOrDefault("volunteering_percentage", 0.0));
            statistics.put("hadSports", dbStatistics.getOrDefault("sports_percentage", 0.0));
            statistics.put("hadCompetition", dbStatistics.getOrDefault("competition_percentage", 0.0));
            statistics.put("hadJob", dbStatistics.getOrDefault("job_percentage", 0.0));
            statistics.put("isInHonorsSociety", dbStatistics.getOrDefault("honors_percentage", 0.0));
            statistics.put("averageGpa", round(dbStatistics.getOrDefault("average_gpa", 0.0)));

            // Add doom scrolled percentage using Java stream (not included in SQL query)
            List<Student> students;
            if (typeParam != null) {
                students = studentRepository.findByStudentType(typeParam);
            } else {
                students = studentRepository.findAll();
            }

            if (!students.isEmpty()) {
                statistics.put("hadDoomScrolled", calculatePercentage(
                        students.stream().filter(Student::getHadDoomScrolled).count(), students.size()));
            } else {
                statistics.put("hadDoomScrolled", 0.0);
            }

            return statistics;

        } catch (Exception e) {
            // Fallback to Java-based calculation if the SQL query fails
            List<Student> students;

            if (typeParam != null) {
                students = studentRepository.findByStudentType(typeParam);
            } else {
                students = studentRepository.findAll();
            }

            if (students.isEmpty()) {
                return new HashMap<>();
            }

            int totalStudents = students.size();
            Map<String, Double> statistics = new HashMap<>();

            // Calculate percentages for general attributes
            statistics.put("hadLeadership", calculatePercentage(
                    students.stream().filter(Student::getHadLeadership).count(), totalStudents));

            statistics.put("hadVolunteering", calculatePercentage(
                    students.stream().filter(Student::getHadVolunteering).count(), totalStudents));

            statistics.put("hadSports", calculatePercentage(
                    students.stream().filter(Student::getHadSports).count(), totalStudents));

            statistics.put("hadCompetition", calculatePercentage(
                    students.stream().filter(Student::getHadCompetition).count(), totalStudents));

            statistics.put("hadJob", calculatePercentage(
                    students.stream().filter(Student::getHadJob).count(), totalStudents));

            statistics.put("isInHonorsSociety", calculatePercentage(
                    students.stream().filter(Student::getIsInHonorsSociety).count(), totalStudents));

            statistics.put("hadDoomScrolled", calculatePercentage(
                    students.stream().filter(Student::getHadDoomScrolled).count(), totalStudents));

            // Calculate average GPA
            double averageGpa = students.stream()
                    .filter(s -> s.getGpa() != null)
                    .map(Student::getGpa)
                    .mapToDouble(BigDecimal::doubleValue)
                    .average()
                    .orElse(0.0);

            statistics.put("averageGpa", round(averageGpa));

            return statistics;
        }
    }

    /**
     * Get business-specific statistics
     * Uses optimized PostgreSQL queries when possible
     *
     * @return Map of business-specific attribute names to their percentages
     */
    public Map<String, Double> getBusinessStatistics() {
        try {
            Map<String, Double> dbStatistics = statisticsRepository.getBusinessStudentPercentages();

            Map<String, Double> statistics = new HashMap<>();
            statistics.put("hadBusiness", dbStatistics.getOrDefault("had_business_percentage", 0.0));
            statistics.put("inBusinessClub", dbStatistics.getOrDefault("in_business_club_percentage", 0.0));

            return statistics;

        } catch (Exception e) {
            List<Student> businessStudents = studentRepository.findByStudentType("BUSINESS");

            if (businessStudents.isEmpty()) {
                return new HashMap<>();
            }

            int totalBusinessStudents = businessStudents.size();
            Map<String, Double> statistics = new HashMap<>();


            List<BusinessStudent> castedBusinessStudents = businessStudents.stream()
                    .filter(s -> s instanceof BusinessStudent)
                    .map(s -> (BusinessStudent) s)
                    .collect(Collectors.toList());

            statistics.put("hadBusiness", calculatePercentage(
                    castedBusinessStudents.stream().filter(BusinessStudent::getHadBusiness).count(),
                    totalBusinessStudents));

            statistics.put("inBusinessClub", calculatePercentage(
                    castedBusinessStudents.stream().filter(BusinessStudent::getInBusinessClub).count(),
                    totalBusinessStudents));

            return statistics;
        }
    }

    /**
     * Get engineering-specific statistics
     * Uses optimized PostgreSQL queries when possible
     *
     * @return Map of engineering-specific attribute names to their percentages
     */
    public Map<String, Double> getEngineeringStatistics() {
        try {
            Map<String, Double> dbStatistics = statisticsRepository.getEngineeringStudentPercentages();

            Map<String, Double> statistics = new HashMap<>();
            statistics.put("inFbla", dbStatistics.getOrDefault("in_fbla_percentage", 0.0));
            statistics.put("didPersonalProject", dbStatistics.getOrDefault("did_personal_project_percentage", 0.0));

            return statistics;

        } catch (Exception e) {
            List<Student> engineeringStudents = studentRepository.findByStudentType("ENGINEERING");

            if (engineeringStudents.isEmpty()) {
                return new HashMap<>();
            }

            int totalEngineeringStudents = engineeringStudents.size();
            Map<String, Double> statistics = new HashMap<>();

            List<EngineeringStudent> castedEngineeringStudents = engineeringStudents.stream()
                    .filter(s -> s instanceof EngineeringStudent)
                    .map(s -> (EngineeringStudent) s)
                    .collect(Collectors.toList());

            statistics.put("inFbla", calculatePercentage(
                    castedEngineeringStudents.stream().filter(EngineeringStudent::getInFbla).count(),
                    totalEngineeringStudents));

            statistics.put("didPersonalProject", calculatePercentage(
                    castedEngineeringStudents.stream().filter(EngineeringStudent::getDidPersonalProject).count(),
                    totalEngineeringStudents));

            return statistics;
        }
    }

    /**
     * Get medical-specific statistics
     * Uses optimized PostgreSQL queries when possible
     *
     * @return Map of medical-specific attribute names to their percentages
     */
    public Map<String, Double> getMedicalStatistics() {
        try {
            Map<String, Double> dbStatistics = statisticsRepository.getMedicalStudentPercentages();

            Map<String, Double> statistics = new HashMap<>();
            statistics.put("inHosa", dbStatistics.getOrDefault("in_hosa_percentage", 0.0));
            statistics.put("didResearch", dbStatistics.getOrDefault("did_research_percentage", 0.0));

            return statistics;

        } catch (Exception e) {
            List<Student> medicalStudents = studentRepository.findByStudentType("MEDICAL");

            if (medicalStudents.isEmpty()) {
                return new HashMap<>();
            }

            int totalMedicalStudents = medicalStudents.size();
            Map<String, Double> statistics = new HashMap<>();

            List<MedicalStudent> castedMedicalStudents = medicalStudents.stream()
                    .filter(s -> s instanceof MedicalStudent)
                    .map(s -> (MedicalStudent) s)
                    .collect(Collectors.toList());

            statistics.put("inHosa", calculatePercentage(
                    castedMedicalStudents.stream().filter(MedicalStudent::getInHosa).count(),
                    totalMedicalStudents));

            statistics.put("didResearch", calculatePercentage(
                    castedMedicalStudents.stream().filter(MedicalStudent::getDidResearch).count(),
                    totalMedicalStudents));

            return statistics;
        }
    }

    /**
     * Helper method to calculate percentage
     * @param count - Number of students with the attribute
     * @param total - Total number of students
     * @return Percentage as a double
     */
    private double calculatePercentage(long count, int total) {
        if (total == 0) return 0.0;
        return round((double) count / total * 100);
    }

    /**
     * Helper method to round to two decimal places
     * @param value - Value to round
     * @return Rounded value
     */
    private double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}