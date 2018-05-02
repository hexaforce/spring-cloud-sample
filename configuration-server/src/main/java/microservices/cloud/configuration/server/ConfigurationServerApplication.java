package microservices.cloud.configuration.server;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import microservices.cloud.service.utile.ServiceUtileApplication;
import microservices.cloud.service.utile.StartupCompleteEvent;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigurationServerApplication {

	public static void main(String[] args) throws BeansException, IOException {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConfigurationServerApplication.class)
				.sources(ServiceUtileApplication.class)
				.listeners(new ApplicationPidFileWriter())
				.run(args);

		context.getBean(StartupCompleteEvent.class).onComplete(context);

	}

}