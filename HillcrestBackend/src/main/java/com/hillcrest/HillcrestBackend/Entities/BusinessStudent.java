package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "businessstudent")
public class BusinessStudent extends Student {

    // Getters and Setters
    @Column(name = "had_business")
    private Boolean hadBusiness = false;

    @Column(name = "in_business_club")
    private Boolean inBusinessClub = false;

    // Constructors
    public BusinessStudent() {
        super();
        setStudentType("BUSINESS");
    }

    public BusinessStudent(String name) {
        super(name, "BUSINESS");
    }

    // toString
    @Override
    public String toString() {
        return "BusinessStudent{" +
                "studentId=" + getStudentId() +
                ", name='" + getName() + '\'' +
                ", hadBusiness=" + hadBusiness +
                ", inBusinessClub=" + inBusinessClub +
                '}';
    }
}