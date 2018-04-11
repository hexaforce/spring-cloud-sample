package microservices.cloud.tracing.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;
import zipkin.server.internal.EnableZipkinServer;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication

@EnableZipkinServer
public class ZipkinServer {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServer.class, args);
		log.debug("");
	}

}
