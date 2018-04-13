package microservices.cloud.tracing.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class ZipkinServer {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServer.class, args);
	}

}
