package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByMajor(String major);

    List<Student> findByGraduationYear(Integer graduationYear);

    List<Student> findByIsInHonorsSociety(Boolean isInHonorsSociety);

    @Query("SELECT s FROM Student s WHERE s.gpa >= :minGpa")
    List<Student> findByMinimumGpa(@Param("minGpa") BigDecimal minGpa);

    @Query("SELECT s FROM Student s WHERE s.studentType = :type")
    List<Student> findByStudentType(@Param("type") String studentType);

    @Query("SELECT DISTINCT s FROM Student s JOIN s.studentUniversities su WHERE su.university.name = :universityName")
    List<Student> findByUniversityName(@Param("universityName") String universityName);
}