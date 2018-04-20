FROM openjdk:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 8761

ARG JAR_FILE
ADD ${JAR_FILE} service-discovery.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/service-discovery.jar"]
