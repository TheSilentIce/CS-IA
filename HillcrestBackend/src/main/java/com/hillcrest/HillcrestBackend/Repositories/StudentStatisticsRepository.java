package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Repository for student statistics with PostgreSQL-specific queries
 */
@Repository
public interface StudentStatisticsRepository extends JpaRepository<Student, Long> {

    /**
     * Count students with leadership role by student type
     * @param studentType - Type of student
     * @return Count of students with leadership
     */
    @Query(value = "SELECT COUNT(*) FROM student WHERE had_leadership = true AND student_type = :studentType", nativeQuery = true)
    Long countStudentsWithLeadershipByType(@Param("studentType") String studentType);

    /**
     * Count all students by student type
     * @param studentType - Type of student
     * @return Total count of students of that type
     */
    @Query(value = "SELECT COUNT(*) FROM student WHERE student_type = :studentType", nativeQuery = true)
    Long countStudentsByType(@Param("studentType") String studentType);

    /**
     * Get percentage statistics for business students
     * @return Map containing percentages for business-specific attributes
     */
    @Query(value = "SELECT " +
            "(SELECT 100.0 * COUNT(*) / NULLIF((SELECT COUNT(*) FROM businessstudent), 0) FROM businessstudent WHERE had_business = true) as had_business_percentage, " +
            "(SELECT 100.0 * COUNT(*) / NULLIF((SELECT COUNT(*) FROM businessstudent), 0) FROM businessstudent WHERE in_business_club = true) as in_business_club_percentage",
            nativeQuery = true)
    Map<String, Double> getBusinessStudentPercentages();

    /**
     * Get percentage statistics for engineering students
     * @return Map containing percentages for engineering-specific attributes
     */
    @Query(value = "SELECT " +
            "(SELECT 100.0 * COUNT(*) / NULLIF((SELECT COUNT(*) FROM engineeringstudent), 0) FROM engineeringstudent WHERE in_fbla = true) as in_fbla_percentage, " +
            "(SELECT 100.0 * COUNT(*) / NULLIF((SELECT COUNT(*) FROM engineeringstudent), 0) FROM engineeringstudent WHERE did_personal_project = true) as did_personal_project_percentage",
            nativeQuery = true)
    Map<String, Double> getEngineeringStudentPercentages();

    /**
     * Get percentage statistics for medical students
     * @return Map containing percentages for medical-specific attributes
     */
    @Query(value = "SELECT " +
            "(SELECT 100.0 * COUNT(*) / NULLIF((SELECT COUNT(*) FROM medicalstudent), 0) FROM medicalstudent WHERE in_hosa = true) as in_hosa_percentage, " +
            "(SELECT 100.0 * COUNT(*) / NULLIF((SELECT COUNT(*) FROM medicalstudent), 0) FROM medicalstudent WHERE did_research = true) as did_research_percentage",
            nativeQuery = true)
    Map<String, Double> getMedicalStudentPercentages();

    /**
     * Get average GPA by student type
     * @param studentType - Type of student
     * @return Average GPA
     */
    @Query(value = "SELECT AVG(gpa) FROM student WHERE student_type = :studentType", nativeQuery = true)
    Double getAverageGpaByType(@Param("studentType") String studentType);

    /**
     * Get general statistics percentages for all attributes
     * Postgres-optimized batch query
     * @param studentType - Type of student (optional, can be null)
     * @return Map of attribute names to percentage values
     */
    @Query(value = "SELECT " +
            "100.0 * SUM(CASE WHEN had_leadership = true THEN 1 ELSE 0 END) / COUNT(*) as leadership_percentage, " +
            "100.0 * SUM(CASE WHEN had_volunteering = true THEN 1 ELSE 0 END) / COUNT(*) as volunteering_percentage, " +
            "100.0 * SUM(CASE WHEN had_sports = true THEN 1 ELSE 0 END) / COUNT(*) as sports_percentage, " +
            "100.0 * SUM(CASE WHEN had_competition = true THEN 1 ELSE 0 END) / COUNT(*) as competition_percentage, " +
            "100.0 * SUM(CASE WHEN had_job = true THEN 1 ELSE 0 END) / COUNT(*) as job_percentage, " +
            "100.0 * SUM(CASE WHEN is_in_honors_society = true THEN 1 ELSE 0 END) / COUNT(*) as honors_percentage, " +
            "AVG(gpa) as average_gpa " +
            "FROM student " +
            "WHERE (:studentType IS NULL OR student_type = :studentType)",
            nativeQuery = true)
    Map<String, Double> getGeneralStatisticsPercentages(@Param("studentType") String studentType);
}