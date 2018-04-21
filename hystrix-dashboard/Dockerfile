FROM java:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 7979

ARG JAR_FILE
ADD ${JAR_FILE} hystrix-dashboard.jar

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/hystrix-dashboard.jar"]
