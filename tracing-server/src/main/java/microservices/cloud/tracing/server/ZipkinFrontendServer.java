package microservices.cloud.tracing.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@RestController
@CrossOrigin // So that javascript can be hosted elsewhere
public class ZipkinFrontendServer {

	private final static String NAME = "--spring.application.name=";
	private final static String PORT = "--server.port=";

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/")
	public String callBackend() {
		return restTemplate.getForObject("http://localhost:9000/api", String.class);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinFrontendServer.class, NAME + "zipkin-frontend", PORT + 8081);
	}
	
}
