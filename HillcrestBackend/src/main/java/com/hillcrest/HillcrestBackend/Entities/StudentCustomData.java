package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "studentcustomdata")
public class StudentCustomData {

    // Getters and Setters
    @EmbeddedId
    private StudentCustomDataId id = new StudentCustomDataId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "value_data")
    private String valueData;

    // Constructors
    public StudentCustomData() {
    }

    public StudentCustomData(Student student, String keyName, String valueData) {
        this.student = student;
        this.id.setStudentId(student.getStudentId());
        this.id.setKeyName(keyName);
        this.valueData = valueData;
    }

    public void setId(StudentCustomDataId id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
        if (student != null) {
            this.id.setStudentId(student.getStudentId());
        }
    }

    public String getKeyName() {
        return id.getKeyName();
    }

    public void setKeyName(String keyName) {
        this.id.setKeyName(keyName);
    }

    public void setValueData(String valueData) {
        this.valueData = valueData;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCustomData that = (StudentCustomData) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // toString
    @Override
    public String toString() {
        return "StudentCustomData{" +
                "student=" + (student != null ? student.getName() : "null") +
                ", key='" + getKeyName() + '\'' +
                ", value='" + valueData + '\'' +
                '}';
    }

    // Embedded ID class
    @Embeddable
    public static class StudentCustomDataId implements Serializable {

        @Column(name = "student_id")
        private Long studentId;

        @Column(name = "key_name")
        private String keyName;

        // Constructors
        public StudentCustomDataId() {
        }

        public StudentCustomDataId(Long studentId, String keyName) {
            this.studentId = studentId;
            this.keyName = keyName;
        }

        // Getters and Setters
        public Long getStudentId() {
            return studentId;
        }

        public void setStudentId(Long studentId) {
            this.studentId = studentId;
        }

        public String getKeyName() {
            return keyName;
        }

        public void setKeyName(String keyName) {
            this.keyName = keyName;
        }

        // equals and hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StudentCustomDataId that = (StudentCustomDataId) o;
            return Objects.equals(studentId, that.studentId) &&
                    Objects.equals(keyName, that.keyName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, keyName);
        }
    }
}