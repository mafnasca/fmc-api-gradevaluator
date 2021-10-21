package com.fmc.api.student.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Class containing the Unit Tests for theStudentGradeEvalService
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentGradeEvalServiceTests {

    /**
     *  The StudentGradeEvalService
     */
    private StudentGradeEvalService studentGradeEvalService;

    /**
     *  Tests 'getStudentGradeLevel' method
     */
    @Test
    public void getStudentGradeLevel() {
        // Arrange
        int graduationYear = 2021;

        // Act
        int studentLevel = studentGradeEvalService.getStudentGradeLevel(graduationYear);

        // Assert
        MatcherAssert.assertThat(studentLevel, Matchers.equalTo(studentLevel));
    }

    /**
     *  Run before each Test case. Initialize the Dependencies.
     */
    @Before
    public void setup() {
        studentGradeEvalService = new StudentGradeEvalServiceImpl();
    }
}
