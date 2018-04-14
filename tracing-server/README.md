## Starting the Services
In a separate tab or window, start each of [sleuth.webmvc.Frontend](/src/main/java/sleuth/webmvc/Frontend.java) and [sleuth.webmvc.Backend](/src/main/java/sleuth/webmvc/Backend.java):
```bash
$ export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk  
$ mvn clean compile exec:java -Dexec.mainClass=microservices.cloud.tracing.server.ZipkinFrontendServer  
$ mvn clean compile exec:java -Dexec.mainClass=microservices.cloud.tracing.server.ZipkinFrontendServer  
```

Next, run [Zipkin](http://zipkin.io/), which stores and queries traces reported by the above services.

```bash
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```
