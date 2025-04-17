package com.hillcrest.HillcrestBackend.Controllers;

import com.hillcrest.HillcrestBackend.Entities.StudentUniversityView;
import com.hillcrest.HillcrestBackend.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/simple-students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     *  Search endpoint for students with filtering by name, university, and major
     *
     * @param name Optional student name search term
     * @param university Optional university name search term
     * @param major Optional major search term
     * @return List of TablePageDTO objects containing the search results
     */
    @GetMapping("/search")
    public ResponseEntity<List<StudentUniversityView>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String university,
            @RequestParam(required = false) String major) {

        List<StudentUniversityView> results = studentService.searchStudents(name, university, major);
//        List<StudentUniversityView> results = studentService.findAll();

        return ResponseEntity.ok(results);
    }
}