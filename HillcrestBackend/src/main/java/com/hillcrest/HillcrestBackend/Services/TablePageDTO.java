/**
 * TablePageDTO - Data Transfer Object for student information
 *
 * Used to transfer student data between application layers with basic identifying
 * information such as ID, name, university, and major.
 */
package com.hillcrest.HillcrestBackend.Services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablePageDTO {
    private Long id;
    private String name;
    private String university;
    private String major;

    /**
     * Creates a TablePageDTO without an ID
     */
    public TablePageDTO(String name, String university, String major) {
        this.name = name;
        this.university = university;
        this.major = major;
    }

    /**
     * Creates a TablePageDTO with a pre-defined ID
     */
    public TablePageDTO(Long id, String name, String university, String major) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.major = major;
    }
}