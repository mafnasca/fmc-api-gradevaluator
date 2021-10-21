package com.fmc.api.student.controllers;

import com.fmc.api.student.services.StudentGradeEvalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Controller for retrieving the students current grade level
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    /**
     *  The StudentGradeEvalService
     */
    private final StudentGradeEvalService studentGradeEvalService;

    /**
     *  The StudentController constructor
     *  @param studentGradeEvalService: the service that retrieves the student's grade level
     */
    @Autowired
    public StudentController(StudentGradeEvalService studentGradeEvalService) {
        this.studentGradeEvalService = studentGradeEvalService;
    }

    /**
     *  The StudentController's GET endpoint, returns the current grade level of the student.
     *
     *  @param graduationYear: the student's graduation year
     *
     *  @return ResponseEntity<Integer> studentGradeLevel 
     */
    @GetMapping("/student/grade/{graduationYear}")
    public ResponseEntity<Integer> getStudentGradeLevel(@PathVariable Integer graduationYear) {

        if (graduationYear == null) {
            return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
        }

        int studentGradeLevel = studentGradeEvalService.getStudentGradeLevel(graduationYear);

        return new ResponseEntity<Integer>(studentGradeLevel, HttpStatus.OK);
    }
}
