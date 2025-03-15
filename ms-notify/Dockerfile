FROM openjdk:17-jdk-slim

WORKDIR /app
RUN mkdir ./logs

COPY ./build/libs/ms-notify-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "ms-notify-0.0.1-SNAPSHOT.jar"]Ω