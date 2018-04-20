FROM openjdk:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 8080

ARG JAR_FILE
ADD ${JAR_FILE} authorization-server.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/authorization-server.jar"]
