package com.hillcrest.HillcrestBackend.Services;

import com.hillcrest.HillcrestBackend.Entities.Student;
import com.hillcrest.HillcrestBackend.Entities.StudentUniversityView;
import com.hillcrest.HillcrestBackend.Entities.University;
import com.hillcrest.HillcrestBackend.Repositories.StudentCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentCustomRepository studentRepository;

    @Autowired
    public StudentService(StudentCustomRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentUniversityView> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Search for students by name, university name, and major
     * @param studentName Optional student name search term
     * @param universityName Optional university name search term
     * @param major Optional major search term
     * @return List of TablePageDTO containing search results
     */
    public List<StudentUniversityView> searchStudents(String studentName, String universityName, String major) {
        List<StudentUniversityView> students;

        if (isNotEmpty(studentName) && isNotEmpty(universityName) && isNotEmpty(major)) {
            // All three parameters provided
            students = studentRepository.findByNameContainingAndMajorContainingAndUniversityNameContaining(
                    studentName, major, universityName);
        } else if (isNotEmpty(studentName) && isNotEmpty(universityName)) {
            // Student name and university name provided
            students = studentRepository.findByNameContainingAndUniversityNameContaining(
                    studentName, universityName);
        } else if (isNotEmpty(studentName) && isNotEmpty(major)) {
            // Student name and major provided
            students = studentRepository.findByNameContainingAndMajorContaining(
                    studentName, major);
        } else if (isNotEmpty(universityName) && isNotEmpty(major)) {
            // University name and major provided
            students = studentRepository.findByMajorContainingAndUniversityNameContaining(
                    major, universityName);
        } else if (isNotEmpty(studentName)) {
            // Only student name provided
            students = studentRepository.findByNameContainingIgnoreCase(studentName);
        } else if (isNotEmpty(universityName)) {
            // Only university name provided
            students = studentRepository.findByUniversityNameContaining(universityName);
        } else if (isNotEmpty(major)) {
            // Only major provided
            students = studentRepository.findByMajorContainingIgnoreCase(major);
        } else {
            // No parameters provided, return all students
            students = studentRepository.findAll();
        }

        // Convert to DTOs
        return students;
    }

    /**
     * Helper method to check if a string is not null and not empty
     */
    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Convert Student entities to TablePageDTO objects
     * @param students List of Student entities
     * @return List of TablePageDTO objects
     */
    private List<TablePageDTO> convertToTablePageDTOList(List<Student> students) {
        List<TablePageDTO> dtos = new ArrayList<>();

        for (Student student : students) {
            // Get the first university for display (or null if none)
            String universityName = null;
            if (!student.getUniversities().isEmpty()) {
                universityName = student.getUniversities().iterator().next().getName();
            }

            dtos.add(new TablePageDTO(
                    student.getStudentId(),
                    student.getName(),
                    universityName,
                    student.getMajor()
            ));
        }

        return dtos;
    }
}