package com.hillcrest.HillcrestBackend.Services;

import com.hillcrest.HillcrestBackend.Entities.State;
import com.hillcrest.HillcrestBackend.Entities.Student;
import com.hillcrest.HillcrestBackend.Entities.University;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DTO for a state with a map of universities to their students
 */
@Setter
@Getter
public class StateUniversityStudentMapDTO {

    private Long stateId;
    private String stateName;
    private List<UniversityWithStudentsDTO> universitiesWithStudents = new ArrayList<>();
    private int totalUniversities;
    private int totalStudents;

    public StateUniversityStudentMapDTO() {
    }

    public StateUniversityStudentMapDTO(State state, Map<University, List<Student>> universityStudentMap) {
        this.stateId = state.getStateId();
        this.stateName = state.getName();

        for (Map.Entry<University, List<Student>> entry : universityStudentMap.entrySet()) {
            UniversityWithStudentsDTO universityDto = new UniversityWithStudentsDTO(
                    entry.getKey(), entry.getValue());
            universitiesWithStudents.add(universityDto);
        }

        this.totalUniversities = universitiesWithStudents.size();
        this.totalStudents = universityStudentMap.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    /**
     * DTO for a university with its students
     */
    @Getter
    public static class UniversityWithStudentsDTO {
        @Setter
        private Long universityId;
        @Setter
        private String universityName;
        private List<StudentDTO> students = new ArrayList<>();
        @Setter
        private int studentCount;

        public UniversityWithStudentsDTO() {
        }

        public UniversityWithStudentsDTO(University university, List<Student> students) {
            this.universityId = university.getUniversityId();
            this.universityName = university.getName();


            for (Student student : students) {
                this.students.add(new StudentDTO(student));
            }

            this.studentCount = students.size();
        }


        public void setStudents(List<StudentDTO> students) {
            this.students = students;
            this.studentCount = students.size();
        }

    }

    /**
     * DTO for Student
     */
    @Setter
    @Getter
    public static class StudentDTO {
        private Long studentId;
        private String name;
        private String major;
        private String studentType;

        /**
         * Default constructor for StudentDTO
         */
        public StudentDTO() {
        }

        /**
         * This is the constructor for StudentDTO that has all the parameters
         * @param student
         */
        public StudentDTO(Student student) {
            this.studentId = student.getStudentId();
            this.name = student.getName();
            this.major = student.getMajor();
            this.studentType = student.getStudentType();
        }

    }
}
