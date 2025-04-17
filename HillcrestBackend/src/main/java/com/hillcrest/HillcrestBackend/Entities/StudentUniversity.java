/**
 * StudentUniversity - Entity that represents a many-to-many relationship
 * between students and universities
 *
 * This entity maps the relationship between Student and University entities
 * using a composite key. It implements the join table in a many-to-many
 * relationship with additional fields if needed.
 */
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

    /**
     * Creates an empty StudentUniversity object
     */
    public StudentUniversity() {
    }

    /**
     * Creates a StudentUniversity with the given student and university,
     * setting the embedded ID values from the respective entities
     */
    public StudentUniversity(Student student, University university) {
        this.student = student;
        this.university = university;
        this.id.setStudentId(student.getStudentId());
        this.id.setUniversityId(university.getUniversityId());
    }

    /**
     * Sets the composite ID for this relationship
     */
    public void setId(StudentUniversityId id) {
        this.id = id;
    }

    /**
     * Sets the student entity and updates the corresponding ID in the composite key
     */
    public void setStudent(Student student) {
        this.student = student;
        if (student != null) {
            this.id.setStudentId(student.getStudentId());
        }
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
     * Compares this object with another StudentUniversity for equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentUniversity that = (StudentUniversity) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(university, that.university);
    }

    /**
     * Generates a hash code based on the student and university
     */
    @Override
    public int hashCode() {
        return Objects.hash(student, university);
    }

    /**
     * Returns a string representation of this object showing student and university names
     */
    @Override
    public String toString() {
        return "StudentUniversity{" +
                "student=" + (student != null ? student.getName() : "null") +
                ", university=" + (university != null ? university.getName() : "null") +
                '}';
    }

    /**
     * StudentUniversityId - Embedded composite key class for the StudentUniversity entity
     *
     * Serves as the primary key for the StudentUniversity join table, containing
     * IDs from both the Student and University entities.
     */
    @Setter
    @Getter
    @Embeddable
    public static class StudentUniversityId implements Serializable {

        @Column(name = "student_id")
        private Long studentId;

        @Column(name = "university_id")
        private Long universityId;

        /**
         * Creates an empty StudentUniversityId
         */
        public StudentUniversityId() {
        }

        /**
         * Creates a StudentUniversityId with the specified student and university IDs
         */
        public StudentUniversityId(Long studentId, Long universityId) {
            this.studentId = studentId;
            this.universityId = universityId;
        }

        /**
         * Compares this object with another StudentUniversityId for equality
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StudentUniversityId that = (StudentUniversityId) o;
            return Objects.equals(studentId, that.studentId) &&
                    Objects.equals(universityId, that.universityId);
        }

        /**
         * Generates a hash code based on the student ID and university ID
         */
        @Override
        public int hashCode() {
            return Objects.hash(studentId, universityId);
        }
    }
}