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


    public University() {
    }

    public University(String name) {
        this.name = name;
    }


    public void addUniversityState(UniversityState universityState) {
        this.universityStates.add(universityState);
        universityState.setUniversity(this);
    }

    public void removeUniversityState(UniversityState universityState) {
        this.universityStates.remove(universityState);
        universityState.setUniversity(null);
    }


    public Set<State> getStates() {
        Set<State> states = new HashSet<>();
        for (UniversityState us : universityStates) {
            states.add(us.getState());
        }
        return states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        University university = (University) o;
        return universityId != null && universityId.equals(university.universityId);
    }

    @Override
    public int hashCode() {
        return universityId != null ? universityId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", name='" + name + '\'' +
                '}';
    }
}