#! /bin/bash

# Clean Project and install Dependencies
mvn clean install

# Build Container
docker build -t fmc-api-gradevaluator .

# Run Project
docker run -h locahost -p 8080:8080 --expose=8080 -d fmc-api-gradevaluator
