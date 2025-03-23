package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "state")
/**
 * This is the State class
 * It holds the state's id, name, and list of universities that are in it.
 * It will establish a relationship with University
 */
public class State {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "state")
    private Set<UniversityState> universityStates = new HashSet<>();


    /**
     * Default constructor for State
     */
    public State() {
    }

    /**
     * Constructor for State with name parameter
     * @param name
     */
    public State(String name) {
        this.name = name;
    }

    public void addUniversityState(UniversityState universityState) {
        this.universityStates.add(universityState);
        universityState.setState(this);
    }

    public void removeUniversityState(UniversityState universityState) {
        this.universityStates.remove(universityState);
        universityState.setState(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;
        return stateId != null && stateId.equals(state.stateId);
    }

    @Override
    public int hashCode() {
        return stateId != null ? stateId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", name='" + name + '\'' +
                '}';
    }
}