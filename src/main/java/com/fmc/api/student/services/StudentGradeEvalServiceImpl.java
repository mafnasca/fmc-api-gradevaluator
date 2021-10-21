package com.fmc.api.student.services;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Service Implementation for retrieving the students current grade level
 */
@NoArgsConstructor
@Service
public class StudentGradeEvalServiceImpl implements StudentGradeEvalService {

    /**
     *  This method get the students grade level based on the year the student graduated
     *  @param graduationYear: The graduation year of the student
     *  @return Integer studentGradeLevel
     */
    @Override
    public Integer getStudentGradeLevel(int graduationYear) {

        // represents the current graduation year of 12th graders (seniors)
        // @property upcomingGraduationYear
        int upcomingGraduationYear = getUpcomingGraduationYear();

        // If the graduationYear is less than the upcoming graduation year
        // then return 99
        if (graduationYear < upcomingGraduationYear) {
            return 99;
        }

        // Determines the grade level by obtaining the difference between the graduationYear and the upcoming graduation year
        int studentGradeLevel = getGrade(graduationYear - upcomingGraduationYear);


        return studentGradeLevel;
    }

    /**
     *  This method determines the grade level the student is currently in.
     *  @param yearDifference: The year difference between the students graduation year and the upcomingGraduationYear
     *  @return Integer gradeLevel
     */
    private Integer getGrade(int yearDifference) {
        Integer gradeLevel;

        switch(yearDifference) {
            case 0:
                gradeLevel = 12;
                break;
            case 1:
                gradeLevel = 11;
                break;
            case 2:
                gradeLevel = 10;
                break;
            case 3:
                gradeLevel = 9;
                break;
            case 4:
                gradeLevel = 8;
                break;
            case 5:
                gradeLevel = 7;
                break;
            case 6:
                gradeLevel = 6;
                break;
            case 7:
                gradeLevel = 5;
                break;
            case 8:
                gradeLevel = 4;
                break;
            case 9:
                gradeLevel = 3;
                break;
            case 10:
                gradeLevel = 2;
                break;
            case 11:
                gradeLevel = 1;
                break;
            default:
                gradeLevel = 0;
        }
        return gradeLevel;
    }

    /**
     *  This method retrieves the current year today, and formats the year into 'YYYY'
     *
     *  @return Integer currentYear
     */
    private Integer getUpcomingGraduationYear() {
        String yearPattern = "YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yearPattern);
        Date currentDate = new Date();
        int currentYear = Integer.parseInt(simpleDateFormat.format(currentDate));
        return currentYear;
    }
}
