# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the 'target' directory into the container's /app directory
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8081 for the application to be accessible
EXPOSE 8081

# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]