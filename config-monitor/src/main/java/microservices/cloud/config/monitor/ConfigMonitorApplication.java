package microservices.cloud.config.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigMonitorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ConfigMonitorApplication.class, args);
		log.info("Environmen: {}", context.getEnvironment());
	}

}