# spring-cloud-sample  

HystrixDashboard:7979

TurbineStream:8989

RabbitMQ:5672

ConfigServer:8888

EurekaServer:8761

ZuulServer:8765

Zipkin:9411

AuthServer:9000


# Docker  

* All Stop
docker stop $(docker ps -a -q)  
* All Remove
docker rm $(docker ps -a -q)  
* All Image Remove
docker rmi $(docker images -a -q)  

* Build  
docker build

* Push  
docker login
docker push xxxxx/xxxxxxx  

* Run  
docker-compose up

## Docker Image Debug  

docker commit -m "exited" XXXXXXXXXXXXX  
docker run --rm -it XXXXXXXXXXXXXXXXXXXXXXXXXX bash  

## Docker Container Link Debug 

docker network inspect bridge  

# Nodejs



# RabbitMQ  

* Image Download & Run 
docker run -it -d -p 5672:5672 -p 25672:25672 --hostname rabbitmq --name rabbit-server rabbitmq:alpine  

* Image Download & Run whit Management  
docker run -it -d -p 5672:5672 -p 15672:15672 -p 25672:25672 --hostname rabbitmq --name rabbit-server rabbitmq:management-alpine  

# MySQL  

docker run -it -d -p 3306:3306 --hostname mysql --name mysql-server -e MYSQL_ROOT_PASSWORD=password mysql:5  

# Redis  

docker run -it -d -p 6379:6379 --hostname redis --name redis-server redis:3-alpine  

# MongoDB  

docker run -it -d --hostname mongo --name mongo-server -d -p 27017:27017 -p 28017:28017 mongo:jessie

# ELK Stack (Elasticsearch/Logstash/Kibana)  

git clone https://github.com/deviantony/docker-elk.git  
cd docker-elk  
docker-compose up  

# Zipkin  

* Image run
docker run -d -p 9411:9411 openzipkin/zipkin

* Code to Run
git clone https://github.com/openzipkin/docker-zipkin.git  
cd docker-zipkin  
docker-compose up

# Jenkins  

* Jenkins on ubuntu
wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins

# Sonarqube  

docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:alpine  

# Maven 

* Maven S3 Deploy
mvn clean install deploy -DaltDeploymentRepository=aws-snapshot::default::s3://microservice.hexaforce.io/snapshot  

* Maven S3 Deploy(Parent POM only)
mvn clean install deploy -N -DaltDeploymentRepository=aws-snapshot::default::s3://microservice.hexaforce.io/snapshot  

* Maven S3 Deploy(Deploy whit Force Update)
mvn clean install deploy -U -DaltDeploymentRepository=aws-snapshot::default::s3://microservice.hexaforce.io/snapshot  

* Maven Docker Build
cd /root/spring-cloud-sample/configuration-server; mvn dockerfile:build -P docker  
cd /root/spring-cloud-sample/service-discovery;    mvn dockerfile:build -P docker  
cd /root/spring-cloud-sample/gateway-proxy;        mvn dockerfile:build -P docker  
cd /root/spring-cloud-sample/authorization-server; mvn dockerfile:build -P docker  
cd /root/spring-cloud-sample/hystrix-dashboard;    mvn dockerfile:build -P docker  
cd /root/spring-cloud-sample/turbine-stream;       mvn dockerfile:build -P docker  

* Maven Docker Push
cd /root/spring-cloud-sample/configuration-server; mvn clean package docker:push -P docker  
cd /root/spring-cloud-sample/service-discovery;    mvn clean package docker:push -P docker  
cd /root/spring-cloud-sample/gateway-proxy;        mvn clean package docker:push -P docker  
cd /root/spring-cloud-sample/authorization-server; mvn clean package docker:push -P docker  
cd /root/spring-cloud-sample/hystrix-dashboard;    mvn clean package docker:push -P docker  
cd /root/spring-cloud-sample/turbine-stream;       mvn clean package docker:push -P docker  
