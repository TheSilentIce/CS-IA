package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.Student;
import com.hillcrest.HillcrestBackend.Entities.StudentUniversityView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCustomRepository extends JpaRepository<StudentUniversityView, Long> {

    // Simple query to find students by name containing a substring (case insensitive)
    @Query("SELECT DISTINCT s FROM StudentUniversityView s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<StudentUniversityView> findByNameContainingIgnoreCase(@Param("name") String name);

    // Simple query to find students by major containing a substring (case insensitive)
    @Query("SELECT DISTINCT s FROM StudentUniversityView s WHERE LOWER(s.major) LIKE LOWER(CONCAT('%', :major, '%'))")
    List<StudentUniversityView> findByMajorContainingIgnoreCase(@Param("major") String major);

    @Query("SELECT DISTINCT s FROM StudentUniversityView s WHERE LOWER(s.universityName) LIKE LOWER(CONCAT('%', :universityName, '%'))")
    List<StudentUniversityView> findByUniversityNameContaining(@Param("universityName") String universityName);

    // Custom JPQL query to find students by both name and major
    @Query("SELECT s FROM StudentUniversityView s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(s.major) LIKE LOWER(CONCAT('%', :major, '%'))")
    List<StudentUniversityView> findByNameContainingAndMajorContaining(@Param("name") String name, @Param("major") String major);


    // Custom JPQL query to find students by name and university
    @Query("SELECT s FROM StudentUniversityView s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(s.universityName) LIKE LOWER(CONCAT('%', :universityName, '%'))")
    List<StudentUniversityView> findByNameContainingAndUniversityNameContaining(@Param("name") String name, @Param("universityName") String universityName);

    // Custom JPQL query to find students by major and university
    @Query("SELECT s FROM StudentUniversityView s WHERE LOWER(s.major) LIKE LOWER(CONCAT('%', :major, '%')) AND LOWER(s.universityName) LIKE LOWER(CONCAT('%', :universityName, '%'))")
    List<StudentUniversityView> findByMajorContainingAndUniversityNameContaining(@Param("major") String major, @Param("universityName") String universityName);

    // Custom JPQL query to find students by name, major and university
    @Query("SELECT s FROM StudentUniversityView s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', :name, '%')) AND LOWER(s.major) LIKE LOWER(CONCAT('%', :major, '%')) AND LOWER(s.universityName) LIKE LOWER(CONCAT('%', :universityName, '%'))")
    List<StudentUniversityView> findByNameContainingAndMajorContainingAndUniversityNameContaining(
            @Param("name") String name,
            @Param("major") String major,
            @Param("universityName") String universityName);
}