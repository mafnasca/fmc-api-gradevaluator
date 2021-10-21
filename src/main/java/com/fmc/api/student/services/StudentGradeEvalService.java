package com.fmc.api.student.services;

/**
 *  Service for retrieving the students current grade level
 */
public interface StudentGradeEvalService {
    Integer getStudentGradeLevel(int graduationYear);
}
