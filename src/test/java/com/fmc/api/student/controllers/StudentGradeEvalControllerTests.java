package com.fmc.api.student.controllers;

import com.fmc.api.student.services.StudentGradeEvalServiceImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class containing the Unit Tests for the StudentGradeEvalController
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentGradeEvalControllerTests {

    /**
     *  The student grade level url
     */
    private static final String url = "/api/student/grade/{graduationYear}";

    /**
     *  The Mock Mvc
     */
    private MockMvc mockMvc;

    /**
      *  Tests the 'getStudentGradeLevel' method
      *
     */
    @Test
    public void getStudentGradeLevel() throws Exception {
        // Arrange
        int graduationYear = 2021;

        // Act
        MvcResult mvcResult = mockMvc.perform(get(url, graduationYear)).andExpect(status().is(200)).andReturn();

        // Assert
        int gradeLevel = Integer.parseInt(mvcResult.getResponse().getContentAsString());
        MatcherAssert.assertThat(gradeLevel, Matchers.equalTo(12));
    }

    /**
     *  Tests the 'getStudentGradeLevel' method, expects 99
     *
     */
    @Test
    public void getStudentGradeLevel_expect99() throws Exception {
        // Arrange
        int graduationYear = 2014;

        // Act
        MvcResult mvcResult = mockMvc.perform(get(url, graduationYear)).andExpect(status().is(200)).andReturn();

        // Assert
        int gradeLevel = Integer.parseInt(mvcResult.getResponse().getContentAsString());
        MatcherAssert.assertThat(gradeLevel, Matchers.equalTo(99));
    }

    /**
     *  Tests the 'getStudentGradeLevel' method, expects 0
     */
    @Test
    public void getStudentGradeLevel_expect0() throws Exception {
        // Arrange
        int graduationYear = 2033;

        // Act
        MvcResult mvcResult = mockMvc.perform(get(url, graduationYear)).andExpect(status().is(200)).andReturn();

        // Assert
        int gradeLevel = Integer.parseInt(mvcResult.getResponse().getContentAsString());
        MatcherAssert.assertThat(gradeLevel, Matchers.equalTo(0));
    }

    /**
     *  Run before each Test case. Initialize the Dependencies.
     */
    @Before
    public void setup() {
       this.mockMvc = MockMvcBuilders.standaloneSetup(new StudentController(new StudentGradeEvalServiceImpl())).build();
    }
}
