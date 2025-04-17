package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * A composite entity view that combines Student and University information.
 * This can be used for fetching joined data efficiently.
 */
@Entity
@Setter
@Getter
@Table(name = "student_university_view")
public class StudentUniversityView {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "major")
    private String major;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @Column(name = "gpa")
    private BigDecimal gpa;

    @Column(name = "sat")
    private Integer sat;

    @Column(name = "act")
    private Integer act;

    @Column(name = "student_type")
    private String studentType;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_name")
    private String universityName;

    // Flag fields from Student
    @Column(name = "is_in_honors_society")
    private Boolean isInHonorsSociety;

    @Column(name = "had_volunteering")
    private Boolean hadVolunteering;

    @Column(name = "had_sports")
    private Boolean hadSports;

    @Column(name = "had_leadership")
    private Boolean hadLeadership;

    @Column(name = "had_competition")
    private Boolean hadCompetition;

    @Column(name = "had_job")
    private Boolean hadJob;

    public StudentUniversityView() {
    }

    // Constructor with essential fields
    public StudentUniversityView(Long studentId, String studentName, String major, Long universityId, String universityName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
        this.universityId = universityId;
        this.universityName = universityName;

        this.id = (studentId * 1000) + universityId;
    }

    // Full constructor
    public StudentUniversityView(Long studentId, String studentName, String major, Integer graduationYear,
                                 BigDecimal gpa, Integer sat, Integer act, String studentType,
                                 Boolean isInHonorsSociety, Boolean hadVolunteering, Boolean hadSports,
                                 Boolean hadLeadership, Boolean hadCompetition, Boolean hadJob,
                                 Long universityId, String universityName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
        this.graduationYear = graduationYear;
        this.gpa = gpa;
        this.sat = sat;
        this.act = act;
        this.studentType = studentType;
        this.isInHonorsSociety = isInHonorsSociety;
        this.hadVolunteering = hadVolunteering;
        this.hadSports = hadSports;
        this.hadLeadership = hadLeadership;
        this.hadCompetition = hadCompetition;
        this.hadJob = hadJob;
        this.universityId = universityId;
        this.universityName = universityName;

        // Generate a composite ID
        this.id = (studentId * 1000) + universityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentUniversityView that = (StudentUniversityView) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StudentUniversityView{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", major='" + major + '\'' +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}