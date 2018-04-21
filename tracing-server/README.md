## Build the Services
docker build -t hexaforce/tracing-server . -m 1g

## Starting the Services
docker run -it -d -p 9411:9411 hexaforce/tracing-server

## Push the Services
docker push hexaforce/tracing-server