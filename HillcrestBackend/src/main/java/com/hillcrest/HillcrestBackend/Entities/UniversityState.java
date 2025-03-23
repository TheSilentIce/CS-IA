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

    // Getters and Setters
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

    // Constructors
    public UniversityState() {
    }

    public UniversityState(University university, State state) {
        this.university = university;
        this.state = state;
        this.id.setUniversityId(university.getUniversityId());
        this.id.setStateId(state.getStateId());
    }

    public void setUniversity(University university) {
        this.university = university;
        if (university != null) {
            this.id.setUniversityId(university.getUniversityId());
        }
    }

    public void setState(State state) {
        this.state = state;
        if (state != null) {
            this.id.setStateId(state.getStateId());
        }
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniversityState that = (UniversityState) o;
        return Objects.equals(university, that.university) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(university, state);
    }

    // toString
    @Override
    public String toString() {
        return "UniversityState{" +
                "university=" + (university != null ? university.getName() : "null") +
                ", state=" + (state != null ? state.getName() : "null") +
                '}';
    }

    // Embedded ID class
    @Setter
    @Getter
    @Embeddable
    public static class UniversityStateId implements Serializable {

        // Getters and Setters
        @Column(name = "university_id")
        private Long universityId;

        @Column(name = "state_id")
        private Long stateId;

        // Constructors
        public UniversityStateId() {
        }

        public UniversityStateId(Long universityId, Long stateId) {
            this.universityId = universityId;
            this.stateId = stateId;
        }

        // equals and hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            UniversityStateId that = (UniversityStateId) o;
            return Objects.equals(universityId, that.universityId) &&
                    Objects.equals(stateId, that.stateId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(universityId, stateId);
        }
    }
}