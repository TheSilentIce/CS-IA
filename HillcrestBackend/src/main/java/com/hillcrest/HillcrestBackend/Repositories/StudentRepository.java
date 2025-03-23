package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * This interface allows access to Student tables and relations
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Find a student by name
     * @param name - name of student
     * @return - Student Object
     */
    List<Student> findByName(String name);

    /**
     * Find a student by major
     * @param major - major of student
     * @return - Student Object
     */
    List<Student> findByMajor(String major);

    /**
     * Find a student by graduationYear
     * @param graduationYear - graduationYear of student
     * @return - Student Object
     */
    List<Student> findByGraduationYear(Integer graduationYear);

    @Query("SELECT s FROM Student s WHERE s.gpa >= :minGpa")
    List<Student> findByMinimumGpa(@Param("minGpa") BigDecimal minGpa);

    @Query("SELECT s FROM Student s WHERE s.studentType = :type")
    List<Student> findByStudentType(@Param("type") String studentType);

    /**
     * Find the Students that go to a specific university
     * @param universityName - name of university
     * @return - list of students who attend
     */
    @Query("SELECT DISTINCT s FROM Student s JOIN s.studentUniversities su WHERE su.university.name = :universityName")
    List<Student> findByUniversityName(@Param("universityName") String universityName);
}