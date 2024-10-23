# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Add the jar file produced by the Spring Boot application build to the container
COPY ./build/libs/quiz-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which your Spring Boot application will run
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","/app/app.jar"]
