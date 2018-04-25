package microservices.cloud.authorization.server;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import microservices.cloud.service.utile.StartupCompleteEvent;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
@SessionAttributes("authorizationRequest")
public class AuthorizationServerApplication implements WebMvcConfigurer {

	public static void main(String[] args) throws BeansException, IOException {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(AuthorizationServerApplication.class)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		
		context.getBean(StartupCompleteEvent.class).onComplete(context);
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}

}