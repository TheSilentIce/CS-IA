package com.hillcrest.HillcrestBackend.Entities;

import com.hillcrest.HillcrestBackend.Entities.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "medicalstudent")
public class MedicalStudent extends Student {


    @Column(name = "in_hosa")
    private Boolean inHosa = false;

    @Column(name = "did_research")
    private Boolean didResearch = false;


    public MedicalStudent() {
        super();
        setStudentType("MEDICAL");
    }

    public MedicalStudent(String name) {
        super(name, "MEDICAL");
    }

    @Override
    public String toString() {
        return "MedicalStudent{" +
                "studentId=" + getStudentId() +
                ", name='" + getName() + '\'' +
                ", inHosa=" + inHosa +
                ", didResearch=" + didResearch +
                '}';
    }
}