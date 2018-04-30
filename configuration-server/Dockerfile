FROM java:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 8888

ARG JAR_FILE
ADD ${JAR_FILE} configuration-server.jar

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/configuration-server.jar"]
