package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.StudentUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Interface that allows access to student university table
 */
public interface StudentUniversityRepository extends JpaRepository<StudentUniversity, Long> {

    /**
     * List of StudentUniversities by studentId
     * @param studentId - id of Student
     * @return - list of StudentUniversities
     */
    List<StudentUniversity> findByStudentStudentId(Long studentId);

    /**
     * List of StudentUniversities by universityId
     * @param universityId - id of university
     * @return - list of StudentUniversities
     */
    List<StudentUniversity> findByUniversityUniversityId(Long universityId);
}