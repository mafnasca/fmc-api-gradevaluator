FROM adoptopenjdk/openjdk11:alpine-jre

# The application's jar file
ARG JAR_FILE=target/fmc-api-gradevaluator-0.0.1-SNAPSHOT.jar

# Add the application's jar to container
ADD ${JAR_FILE} fmc-api-gradevaluator

# Run the jar file
ENTRYPOINT ["java", "-jar", "fmc-api-gradevaluator"]
