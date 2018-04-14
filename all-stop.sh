#!/usr/bin/env bash

export SAMPLE=/home/vagrant/spring-cloud-sample

function note() {
    local GREEN NC
    GREEN='\033[0;32m'
    NC='\033[0m' # No Color
    printf "\n${GREEN}$@  ${NC}\n" >&2
}

function starting_wait() {
  while true
    do
      if [ ! -f $1 ]; then
          sleep 3
      else
          break
      fi
    done
}

set -e

cd $SAMPLE/config-server
note "Starting config-server..."
mvn spring-boot:run &
starting_wait $SAMPLE/config-server"/.startup"

cd $SAMPLE/service-discovery
note "Starting service-discovery..."
mvn spring-boot:run &


cd $SAMPLE/gateway
note "Starting gateway..."
mvn spring-boot:run &


cd $SAMPLE/authorization-server
note "Starting authorization-server..."
mvn spring-boot:run &


cd $SAMPLE/turbine-stream
note "Starting turbine-stream..."
mvn spring-boot:run &


cd $SAMPLE/hystrix-dashboard
note "Starting hystrix-dashboard..."
mvn spring-boot:run &


