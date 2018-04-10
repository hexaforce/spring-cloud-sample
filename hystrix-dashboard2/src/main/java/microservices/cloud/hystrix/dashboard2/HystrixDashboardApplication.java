package microservices.cloud.hystrix.dashboard2;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystrixDashboardApplication extends SpringBootServletInitializer {

	static {

		// for localhost testing only
		log.warn("Will now disable hostname check in SSL, only to be used during development");
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

	}

	public static void main(String[] args) {

		new SpringApplicationBuilder(HystrixDashboardApplication.class).web(WebApplicationType.SERVLET).run(args);

	}

	@RequestMapping("/")
	public String home() {

		return "forward:/hystrix";

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(HystrixDashboardApplication.class).web(WebApplicationType.SERVLET);

	}

}