package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "businessstudent")

/**
 * The BusinessStudent class inherits from Student class
 * In addition to core data from Student, it also has whether the student has been in a business club or owned a business
 *
 */
public class BusinessStudent extends Student {
    @Column(name = "had_business")
    private Boolean hadBusiness = false;

    @Column(name = "in_business_club")
    private Boolean inBusinessClub = false;

    /**
     * This is essentially the default constructor for the BusinessStudent class
     */
    public BusinessStudent() {
        super();
        setStudentType("BUSINESS");
    }

    /**
     * This constructor acts as a sort of bare minimum constructor that one can use as working data.
     * @param name
     */
    public BusinessStudent(String name) {
        super(name, "BUSINESS");
    }

    /**
     *
     * @return
     */
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