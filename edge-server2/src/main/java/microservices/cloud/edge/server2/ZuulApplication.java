package microservices.cloud.edge.server2;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication

@Controller
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(ZuulApplication.class).web(WebApplicationType.SERVLET).run(args);
		log.debug("");
	}

}