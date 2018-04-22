FROM java:alpine
MAINTAINER Tomokazu Tantaka <relics9@gmail.com>

ENV VERSION 6.2.4

EXPOSE 9600 5601

RUN apk --no-cache add bash nodejs

COPY elasticsearch-6.2.4 /elasticsearch
RUN adduser -D -u 1000 elasticsearch
RUN chown elasticsearch -R /elasticsearch

RUN mkdir /var/tmp/elasticsearch
RUN chmod 777 /var/tmp/elasticsearch
RUN chown elasticsearch -R /var/tmp/elasticsearch
ENV ES_TMPDIR /var/tmp/elasticsearch

COPY kibana-6.2.4-linux-x86_64 /kibana

COPY logstash-6.2.4 /logstash
COPY /etc/conf.d/logstash /etc/conf.d/logstash

ADD elk.sh elk.sh
CMD ["bash", "-ex", "elk.sh"]
