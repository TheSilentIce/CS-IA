package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "engineeringstudent")
public class EngineeringStudent extends Student {


    @Column(name = "in_fbla")
    private Boolean inFbla = false;

    @Column(name = "did_personal_project")
    private Boolean didPersonalProject = false;


    public EngineeringStudent() {
        super();
        setStudentType("ENGINEERING");
    }

    public EngineeringStudent(String name) {
        super(name, "ENGINEERING");
    }

    @Override
    public String toString() {
        return "EngineeringStudent{" +
                "studentId=" + getStudentId() +
                ", name='" + getName() + '\'' +
                ", inFbla=" + inFbla +
                ", didPersonalProject=" + didPersonalProject +
                '}';
    }
}