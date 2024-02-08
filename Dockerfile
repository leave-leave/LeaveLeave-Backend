FROM openjdk:17-oracle

ARG URL
ENV URL ${URL}

ARG USERNAME
ENV USERNAME ${USERNAME}

ARG PASSWORD
ENV PASSWORD ${PASSWORD}

COPY build/libs/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
