# FMC API - Grade Level Evaluator

The Grade Level Evaluator allows users to submit there high school graduation year and receive 
an output in regards to thier current grade level 

## Functional Requirements
Create an endpoint in Springboot to find the current grade of student given their year of high school graduation.

- If current date exceeds the graduation year return 99 else return the grade 1-12. 
- If current date is lower than 12 years for graduation return 0

## Clone the repository
1. git clone https://github.com/mafnasca/fmc-api-gradevaluator.git

## Get started using command line 
1. mvn clean install 
2. mvn spring-boot:run 
3. curl -X GET http://localhost:8080/api/student/grade/{graduationYear}

## Get started using Docker 
1. mvn clean install
2. docker build -t fmc-api-gradevaluator .
3. docker run -h locahost -p 8080:8080 --expose=8080 -d fmc-api-gradevaluator
4. curl -X GET http://localhost:8080/api/student/grade/{graduationYear}

## Endpoints 
```
/api/student/grade/{graduationYear} [GET]
```
