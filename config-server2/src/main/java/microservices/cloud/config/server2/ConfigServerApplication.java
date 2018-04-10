package microservices.cloud.config.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication

@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ConfigServerApplication.class, args);

		log.info("Connected to RabbitMQ at: {}", context.getEnvironment().getProperty("spring.rabbitmq.host"));

	}

}