package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.StudentUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentUniversityRepository extends JpaRepository<StudentUniversity, Long> {

    List<StudentUniversity> findByStudentStudentId(Long studentId);

    List<StudentUniversity> findByUniversityUniversityId(Long universityId);
}