FROM openjdk:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 9411

ARG JAR_FILE
ADD ${JAR_FILE} tracing-server.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/tracing-server.jar"]
