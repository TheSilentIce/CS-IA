package com.hillcrest.HillcrestBackend.Services;

import com.hillcrest.HillcrestBackend.Entities.State;
import com.hillcrest.HillcrestBackend.Entities.Student;
import com.hillcrest.HillcrestBackend.Entities.University;
import com.hillcrest.HillcrestBackend.Repositories.StateRepository;
import com.hillcrest.HillcrestBackend.Repositories.StudentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UniversityStudentMapService {

    private final StateRepository stateRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public UniversityStudentMapService(
            StateRepository stateRepository,
            StudentRepository studentRepository) {
        this.stateRepository = stateRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Get a state by name
     *
     * @param stateName Name of the state to find
     * @return Optional with the state if found, empty otherwise
     */
    public Optional<State> getStateByName(String stateName) {
        State state = stateRepository.findByName(stateName);
        return Optional.ofNullable(state);
    }

    /**
     * Get all universities in a state
     *
     * @param stateName The state name
     * @return List of universities in the state
     */
    public List<University> getUniversitiesInState(String stateName) {
        Optional<State> stateOpt = getStateByName(stateName);
        if (stateOpt.isPresent()) {
            State state = stateOpt.get();
            return state.getUniversityStates().stream()
                    .map(universityState -> universityState.getUniversity())
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    /**
     * Get all students for a specific university
     *
     * @param university The university
     * @return List of students attending this university
     */
    public List<Student> getStudentsForUniversity(University university) {
        return studentRepository.findByUniversityName(university.getName());
    }

    /**
     * Build a map where keys are universities and values are lists of students attending each university
     *
     * @param stateName The state name
     * @return Map from University to List of Students, or empty map if state not found
     */
    public Map<University, List<Student>> getUniversityStudentMap(String stateName) {
        List<University> universities = getUniversitiesInState(stateName);
        Map<University, List<Student>> universityStudentMap = new HashMap<>();

        for (University university : universities) {
            List<Student> students = getStudentsForUniversity(university);
            universityStudentMap.put(university, students);
        }

        return universityStudentMap;
    }

    /**
     * Get a state with its universities and associated students as a map
     *
     * @param stateName The state name
     * @return Optional containing state and university-student map if state exists, empty otherwise
     */
    public Optional<StateUniversityStudentMapResult> getStateWithUniversityStudentMap(String stateName) {
        Optional<State> stateOpt = getStateByName(stateName);

        if (stateOpt.isEmpty()) {
            return Optional.empty();
        }

        State state = stateOpt.get();
        Map<University, List<Student>> universityStudentMap = getUniversityStudentMap(stateName);

        return Optional.of(new StateUniversityStudentMapResult(state, universityStudentMap));
    }

    /**
     * Data class to hold a state and its university-student map
     */
    @Getter
    public static class StateUniversityStudentMapResult {
        private final State state;
        private final Map<University, List<Student>> universityStudentMap;

        public StateUniversityStudentMapResult(State state, Map<University, List<Student>> universityStudentMap) {
            this.state = state;
            this.universityStudentMap = universityStudentMap;
        }

    }
}
