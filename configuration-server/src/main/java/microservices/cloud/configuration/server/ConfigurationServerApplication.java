package microservices.cloud.configuration.server;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

import microservices.cloud.service.utile.ServiceUtileApplication;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerApplication {

	public static void main(String[] args) throws BeansException, IOException {

		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(ServiceUtileApplication.class)
				.sources(ConfigurationServerApplication.class)
				.listeners(new ApplicationPidFileWriter()).run(args);

		context.getBean(StartupCompleteEvent.class).onComplete();

	}

}