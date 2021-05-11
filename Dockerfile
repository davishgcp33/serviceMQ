FROM openjdk:11.0.11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app1.jar
ENTRYPOINT ["java","-jar","/app.jar"]