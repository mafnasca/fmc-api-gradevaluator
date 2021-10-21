package com.fmc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;

/**
 *  FMC Grade Level Evaluator Service
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.freddiemac.gradeevaluator")
public class FmcApiGradevaluatorApplication {
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(FmcApiGradevaluatorApplication.class, args);
	}
}
