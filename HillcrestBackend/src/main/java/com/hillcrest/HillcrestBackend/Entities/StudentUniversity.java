package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "studentuniversity")
public class StudentUniversity {


    @EmbeddedId
    private StudentUniversityId id = new StudentUniversityId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("universityId")
    @JoinColumn(name = "university_id")
    private University university;


    public StudentUniversity() {
    }

    public StudentUniversity(Student student, University university) {
        this.student = student;
        this.university = university;
        this.id.setStudentId(student.getStudentId());
        this.id.setUniversityId(university.getUniversityId());
    }

    public void setId(StudentUniversityId id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
        if (student != null) {
            this.id.setStudentId(student.getStudentId());
        }
    }

    public void setUniversity(University university) {
        this.university = university;
        if (university != null) {
            this.id.setUniversityId(university.getUniversityId());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentUniversity that = (StudentUniversity) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, university);
    }


    @Override
    public String toString() {
        return "StudentUniversity{" +
                "student=" + (student != null ? student.getName() : "null") +
                ", university=" + (university != null ? university.getName() : "null") +
                '}';
    }

    // Embedded ID class
    @Setter
    @Getter
    @Embeddable
    public static class StudentUniversityId implements Serializable {


        @Column(name = "student_id")
        private Long studentId;

        @Column(name = "university_id")
        private Long universityId;

        public StudentUniversityId() {
        }

        public StudentUniversityId(Long studentId, Long universityId) {
            this.studentId = studentId;
            this.universityId = universityId;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StudentUniversityId that = (StudentUniversityId) o;
            return Objects.equals(studentId, that.studentId) &&
                    Objects.equals(universityId, that.universityId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, universityId);
        }
    }
}