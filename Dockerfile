FROM ubuntu:latest
LABEL authors="eeuunn"
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["top", "-b"]