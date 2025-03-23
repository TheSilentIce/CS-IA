package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Interface for University
 */
public interface UniversityRepository extends JpaRepository<University, Long> {
    /**
     * find university by name
     * @param name - name of university
     * @return - returns University object
     */
    University findByName(String name);
}