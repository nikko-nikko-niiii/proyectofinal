FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/proyectoFinal-0.0.1.jar
COPY ${JAR_FILE} mineraiot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mineraiot.jar"]