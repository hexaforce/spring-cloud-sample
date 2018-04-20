FROM openjdk:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 8989

ARG JAR_FILE
ADD ${JAR_FILE} turbine-stream.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/turbine-stream.jar"]
