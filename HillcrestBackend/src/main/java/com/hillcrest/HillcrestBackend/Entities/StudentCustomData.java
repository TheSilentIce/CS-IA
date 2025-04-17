/**
 * StudentCustomData - Entity representing custom key-value data associated with students
 *
 * This entity stores flexible, schema-less data for students using a key-value
 * pattern. Each record has a student reference, a key name, and a value.
 * The primary key is a composite of student ID and key name.
 */
package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "studentcustomdata")
public class StudentCustomData {

    @EmbeddedId
    private StudentCustomDataId id = new StudentCustomDataId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "value_data")
    private String valueData;

    /**
     * Creates an empty StudentCustomData object
     */
    public StudentCustomData() {
    }

    /**
     * Creates a StudentCustomData with the specified student, key and value
     */
    public StudentCustomData(Student student, String keyName, String valueData) {
        this.student = student;
        this.id.setStudentId(student.getStudentId());
        this.id.setKeyName(keyName);
        this.valueData = valueData;
    }

    /**
     * Sets the composite ID for this custom data
     */
    public void setId(StudentCustomDataId id) {
        this.id = id;
    }

    /**
     * Sets the student entity and updates the student ID in the composite key
     */
    public void setStudent(Student student) {
        this.student = student;
        if (student != null) {
            this.id.setStudentId(student.getStudentId());
        }
    }

    /**
     * Returns the key name from the composite ID
     */
    public String getKeyName() {
        return id.getKeyName();
    }

    /**
     * Sets the key name in the composite ID
     */
    public void setKeyName(String keyName) {
        this.id.setKeyName(keyName);
    }

    /**
     * Sets the value data for this custom data entry
     */
    public void setValueData(String valueData) {
        this.valueData = valueData;
    }

    /**
     * Compares this object with another StudentCustomData for equality based on ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCustomData that = (StudentCustomData) o;
        return Objects.equals(getId(), that.getId());
    }

    /**
     * Generates a hash code based on the ID
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /**
     * Returns a string representation of this object showing student name, key and value
     */
    @Override
    public String toString() {
        return "StudentCustomData{" +
                "student=" + (student != null ? student.getName() : "null") +
                ", key='" + getKeyName() + '\'' +
                ", value='" + valueData + '\'' +
                '}';
    }

    /**
     * StudentCustomDataId - Embedded composite key class for the StudentCustomData entity
     *
     * Serves as the primary key combining the student ID and key name.
     */
    @Setter
    @Getter
    @Embeddable
    public static class StudentCustomDataId implements Serializable {

        @Column(name = "student_id")
        private Long studentId;

        @Column(name = "key_name")
        private String keyName;

        /**
         * Creates an empty StudentCustomDataId
         */
        public StudentCustomDataId() {
        }

        /**
         * Creates a StudentCustomDataId with the specified student ID and key name
         */
        public StudentCustomDataId(Long studentId, String keyName) {
            this.studentId = studentId;
            this.keyName = keyName;
        }

        /**
         * Compares this object with another StudentCustomDataId for equality
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StudentCustomDataId that = (StudentCustomDataId) o;
            return Objects.equals(studentId, that.studentId) &&
                    Objects.equals(keyName, that.keyName);
        }

        /**
         * Generates a hash code based on the student ID and key name
         */
        @Override
        public int hashCode() {
            return Objects.hash(studentId, keyName);
        }
    }
}