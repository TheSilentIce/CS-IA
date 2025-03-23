package com.hillcrest.HillcrestBackend.Repositories;

import com.hillcrest.HillcrestBackend.Entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * This interface allows access to the State tables
 */
public interface StateRepository extends JpaRepository<State, Long> {
    /**
     * This method return a State based on the name given
     * @param name - name of State
     * @return - State object
     */
    State findByName(String name);
}