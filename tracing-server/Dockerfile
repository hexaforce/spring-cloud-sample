FROM java:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

ENV VERSION 2.7.1

EXPOSE 9411

ADD zipkin.jar zipkin.jar

CMD ["java", "-jar", "zipkin.jar"]