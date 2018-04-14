package microservices.cloud.turbine.stream;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;

@Configuration
@EnableAutoConfiguration
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineStreamApplication {

	public static void main(String[] args) {
		
		boolean cloudEnvironment = new StandardEnvironment().acceptsProfiles("cloud");
		
		WebApplicationType webApplicationType = 
				cloudEnvironment ? WebApplicationType.SERVLET : WebApplicationType.NONE;
		
		new SpringApplicationBuilder(TurbineStreamApplication.class).web(webApplicationType).run(args);
		
	}

}
