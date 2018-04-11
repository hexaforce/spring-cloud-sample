package microservices.cloud.turbine.stream;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication

@EnableTurbineStream
public class TurbineStreamApplication {

	static {

		// for localhost testing only
		log.warn("Will now disable hostname check in SSL, only to be used during development");
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(TurbineStreamApplication.class)
				.run(args);

		log.info("Connected to RabbitMQ at: {}", context.getEnvironment().getProperty("spring.rabbitmq.host"));

	}

}
