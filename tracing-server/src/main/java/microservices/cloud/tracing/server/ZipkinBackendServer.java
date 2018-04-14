package microservices.cloud.tracing.server;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class ZipkinBackendServer {

	@RequestMapping("/api")
	public String printDate() {
		return new Date().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinBackendServer.class, "--spring.application.name=backend", "--server.port=9000");
	}
	
}
