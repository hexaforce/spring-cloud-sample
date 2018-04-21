FROM java:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

EXPOSE 8765

ARG JAR_FILE
ADD ${JAR_FILE} gateway-proxy.jar

ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-proxy.jar"]
