#La imagen base
FROM openjdk:17-jdk-slim
#carpeta base del proyecto imagen
WORKDIR /app
RUN mkdir ./logs
#copiar el jar en la imagen
COPY ./target/ms-user-0.0.1-SNAPSHOT.jar .
#Ejecuta comandos
ENTRYPOINT ["java","-jar","ms-user-0.0.1-SNAPSHOT.jar"]