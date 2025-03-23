package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "student")
@Inheritance(strategy = InheritanceType.JOINED)

/**
 * This is the Student class, where it mostly contains the core information that all students share
 * It also establishes a relationship with University class
 */

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "major")
    private String major;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @Column(name = "is_in_honors_society")
    private Boolean isInHonorsSociety = false;

    @Column(name = "had_volunteering")
    private Boolean hadVolunteering = false;

    @Column(name = "had_sports")
    private Boolean hadSports = false;

    @Column(name = "had_leadership")
    private Boolean hadLeadership = false;

    @Column(name = "had_competition")
    private Boolean hadCompetition = false;

    @Column(name = "gpa", precision = 3, scale = 2)
    private BigDecimal gpa;

    @Column(name = "sat")
    private Integer sat;

    @Column(name = "act")
    private Integer act;

    @Column(name = "had_job")
    private Boolean hadJob = false;

    @Column(name = "had_doom_scrolled")
    private Boolean hadDoomScrolled = false;

    @Column(name = "student_type", nullable = false)
    private String studentType;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentCustomData> customData = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentUniversity> studentUniversities = new HashSet<>();


    public Student() {
    }

    public Student(String name, String studentType) {
        this.name = name;
        this.studentType = studentType;
    }


    public void addCustomData(String key, String value) {
        StudentCustomData data = new StudentCustomData(this, key, value);
        customData.add(data);
    }

    public void removeCustomData(String key) {
        customData.removeIf(data -> data.getKeyName().equals(key));
    }

    public void addUniversity(University university) {
        StudentUniversity studentUniversity = new StudentUniversity(this, university);
        studentUniversities.add(studentUniversity);
    }

    public void removeUniversity(University university) {
        studentUniversities.removeIf(su -> su.getUniversity().equals(university));
    }


    public Set<University> getUniversities() {
        Set<University> universities = new HashSet<>();
        for (StudentUniversity su : studentUniversities) {
            universities.add(su.getUniversity());
        }
        return universities;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return studentId != null && studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return studentId != null ? studentId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", studentType='" + studentType + '\'' +
                '}';
    }
}