package microservices.cloud.authorization.server;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.cloud.service.utile.ServiceUtileApplication;
import microservices.cloud.service.utile.StartupCompleteEvent;

@SpringBootApplication
@RestController
public class AuthorizationServerApplication extends WebSecurityConfigurerAdapter {

	@RequestMapping("/")
	public Message home() {
		return new Message("Hello World");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
		http.authorizeRequests().anyRequest().authenticated();
	}

	public static void main(String[] args) throws BeansException, IOException {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(AuthorizationServerApplication.class)
				.sources(ServiceUtileApplication.class)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		context.getBean(StartupCompleteEvent.class).onComplete(context);
		
	}

}

