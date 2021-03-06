package microservices.cloud.turbine.stream;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;

import microservices.cloud.service.utile.ServiceUtileApplication;
import microservices.cloud.service.utile.StartupCompleteEvent;

@Configuration
@EnableAutoConfiguration
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineStreamApplication {

	public static void main(String[] args) throws BeansException, IOException {
		
		boolean cloudEnvironment = new StandardEnvironment().acceptsProfiles("cloud");
		
		WebApplicationType webApplicationType = 
				cloudEnvironment ? WebApplicationType.SERVLET : WebApplicationType.NONE;
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(TurbineStreamApplication.class)
				.sources(ServiceUtileApplication.class)
				.web(webApplicationType)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		context.getBean(StartupCompleteEvent.class).onComplete(context);
		
	}

}
