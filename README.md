# spring-cloud-sample  

HystrixDashboard:7979

TurbineStream:8989

RabbitMQ:5672

ConfigServer:8888

EurekaServer:8761

ZuulServer:8765

Zipkin:9411

AuthServer:8080


# Docker
docker stop $(docker ps -a -q)  
docker rm $(docker ps -a -q)  
docker rmi $(docker images -a -q)  

# RabbitMQ
docker run -it -d -p 5672:5672 -p 15672:15672 -p 25672:25672 --hostname rabbit-server --name rabbitmq rabbitmq:management-alpine  

docker run -it -d -p 9200:9200 -p 9300:9300 hexaforce/elasticsearch


export ES_TMPDIR=/var/tmp/elasticsearch

docker run -d -p 9200:9200 -p 9300:9300 -p 5601:5601 hexaforce/elk

docker run -it -d -p 5601:5601 hexaforce/kibana


docker push hexaforce/kibana
docker push hexaforce/elasticsearch

# MySQL
sudo docker run --name mysql-server -it -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql:5

## Exited
docker commit -m "exited" XXXXXXXXXXXXX  

docker run --rm -it XXXXXXXXXXXXXXXXXXXXXXXXXX bash  

docker network inspect bridge

mvn clean install deploy -DaltDeploymentRepository=aws-snapshot::default::s3://microservice.hexaforce.io/snapshot

mvn clean install deploy -DaltDeploymentRepository=aws-snapshot::default::s3://microservice.hexaforce.io/snapshot -N


cd /root/spring-cloud-sample/configuration-server; mvn clean package docker:build -P docker
cd /root/spring-cloud-sample/service-discovery;    mvn clean package docker:build -P docker
cd /root/spring-cloud-sample/gateway-proxy;        mvn clean package docker:build -P docker
cd /root/spring-cloud-sample/authorization-server; mvn clean package docker:build -P docker
cd /root/spring-cloud-sample/hystrix-dashboard;    mvn clean package docker:build -P docker
cd /root/spring-cloud-sample/turbine-stream;       mvn clean package docker:build -P docker

cd /root/spring-cloud-sample/configuration-server; mvn dockerfile:build -P docker
cd /root/spring-cloud-sample/service-discovery;    mvn dockerfile:build -P docker
cd /root/spring-cloud-sample/gateway-proxy;        mvn dockerfile:build -P docker
cd /root/spring-cloud-sample/authorization-server; mvn dockerfile:build -P docker
cd /root/spring-cloud-sample/hystrix-dashboard;    mvn dockerfile:build -P docker
cd /root/spring-cloud-sample/turbine-stream;       mvn dockerfile:build -P docker





