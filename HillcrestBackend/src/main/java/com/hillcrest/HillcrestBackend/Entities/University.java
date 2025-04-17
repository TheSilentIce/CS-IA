/**
 * University - Entity representing a higher education institution
 *
 * This entity stores information about universities and their relationships
 * with states through the UniversityState join entity.
 */
package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "university")
    private Set<UniversityState> universityStates = new HashSet<>();

    /**
     * Creates an empty University object
     */
    public University() {
    }

    /**
     * Creates a University with the specified name
     */
    public University(String name) {
        this.name = name;
    }

    /**
     * Adds a UniversityState relationship to this university and sets the
     * bidirectional relationship
     */
    public void addUniversityState(UniversityState universityState) {
        this.universityStates.add(universityState);
        universityState.setUniversity(this);
    }

    /**
     * Removes a UniversityState relationship from this university and clears the
     * bidirectional relationship
     */
    public void removeUniversityState(UniversityState universityState) {
        this.universityStates.remove(universityState);
        universityState.setUniversity(null);
    }

    /**
     * Returns all states associated with this university through UniversityState relationships
     */
    public Set<State> getStates() {
        Set<State> states = new HashSet<>();
        for (UniversityState us : universityStates) {
            states.add(us.getState());
        }
        return states;
    }

    /**
     * Compares this object with another University for equality based on ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University university = (University) o;
        return universityId != null && universityId.equals(university.universityId);
    }

    /**
     * Generates a hash code based on the university ID
     */
    @Override
    public int hashCode() {
        return universityId != null ? universityId.hashCode() : 0;
    }

    /**
     * Returns a string representation of this university showing ID and name
     */
    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", name='" + name + '\'' +
                '}';
    }
}