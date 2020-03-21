# Maven build flow adapted from https://stackoverflow.com/questions/27767264/how-to-dockerize-maven-project-and-how-many-ways-to-accomplish-it
#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/src
COPY pom.xml /home/
RUN mvn -f /home/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/target/*.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/usr/local/lib/app.jar"]
