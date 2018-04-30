package microservices.cloud.hystrix.dashboard;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import microservices.cloud.service.utile.ServiceUtileApplication;
import microservices.cloud.service.utile.StartupCompleteEvent;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
@EnableHystrixDashboard
public class HystrixDashboardApplication extends SpringBootServletInitializer {

	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HystrixDashboardApplication.class).web(WebApplicationType.SERVLET);
	}

	public static void main(String[] args) throws BeansException, IOException {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(HystrixDashboardApplication.class)
				.sources(ServiceUtileApplication.class)
				.listeners(new ApplicationPidFileWriter())
				.web(WebApplicationType.SERVLET)
				.run(args);
		context.getBean(StartupCompleteEvent.class).onComplete(context);

	}

}