package com.hillcrest.HillcrestBackend.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "otherstudent")
public class OtherStudent extends Student {

    public OtherStudent() {
        super();
        setStudentType("OTHER");
    }

    public OtherStudent(String name) {
        super(name, "OTHER");
    }


    @Override
    public String toString() {
        return "OtherStudent{" +
                "studentId=" + getStudentId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}