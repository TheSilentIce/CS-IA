/**
 * UniversityState - Entity representing the many-to-many relationship
 * between universities and states
 *
 * This entity maps the relationship between University and State entities
 * using a composite key. It serves as the join table in a many-to-many
 * relationship.
 */
package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "universitystate")
public class UniversityState {

    @Setter
    @EmbeddedId
    private UniversityStateId id = new UniversityStateId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("universityId")
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stateId")
    @JoinColumn(name = "state_id")
    private State state;

    /**
     * Creates an empty UniversityState object
     */
    public UniversityState() {
    }

    /**
     * Creates a UniversityState with the given university and state,
     * setting the embedded ID values from the respective entities
     */
    public UniversityState(University university, State state) {
        this.university = university;
        this.state = state;
        this.id.setUniversityId(university.getUniversityId());
        this.id.setStateId(state.getStateId());
    }

    /**
     * Sets the university entity and updates the corresponding ID in the composite key
     */
    public void setUniversity(University university) {
        this.university = university;
        if (university != null) {
            this.id.setUniversityId(university.getUniversityId());
        }
    }

    /**
     * Sets the state entity and updates the corresponding ID in the composite key
     */
    public void setState(State state) {
        this.state = state;
        if (state != null) {
            this.id.setStateId(state.getStateId());
        }
    }

    /**
     * Compares this object with another UniversityState for equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniversityState that = (UniversityState) o;
        return Objects.equals(university, that.university) &&
                Objects.equals(state, that.state);
    }

    /**
     * Generates a hash code based on the university and state
     */
    @Override
    public int hashCode() {
        return Objects.hash(university, state);
    }

    /**
     * Returns a string representation of this object showing university and state names
     */
    @Override
    public String toString() {
        return "UniversityState{" +
                "university=" + (university != null ? university.getName() : "null") +
                ", state=" + (state != null ? state.getName() : "null") +
                '}';
    }

    /**
     * UniversityStateId - Embedded composite key class for the UniversityState entity
     *
     * Serves as the primary key for the UniversityState join table, containing
     * IDs from both the University and State entities.
     */
    @Setter
    @Getter
    @Embeddable
    public static class UniversityStateId implements Serializable {

        @Column(name = "university_id")
        private Long universityId;

        @Column(name = "state_id")
        private Long stateId;

        /**
         * Creates an empty UniversityStateId
         */
        public UniversityStateId() {
        }

        /**
         * Creates a UniversityStateId with the specified university and state IDs
         */
        public UniversityStateId(Long universityId, Long stateId) {
            this.universityId = universityId;
            this.stateId = stateId;
        }

        /**
         * Compares this object with another UniversityStateId for equality
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            UniversityStateId that = (UniversityStateId) o;
            return Objects.equals(universityId, that.universityId) &&
                    Objects.equals(stateId, that.stateId);
        }

        /**
         * Generates a hash code based on the university ID and state ID
         */
        @Override
        public int hashCode() {
            return Objects.hash(universityId, stateId);
        }
    }
}