FROM openjdk:8-jdk-alpine
MAINTAINER prasad1025@gmail.com
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080