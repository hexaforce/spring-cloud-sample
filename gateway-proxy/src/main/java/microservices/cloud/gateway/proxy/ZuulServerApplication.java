package microservices.cloud.gateway.proxy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RestController;

import microservices.cloud.service.utile.StartupCompleteEvent;

@EnableZuulProxy
@RestController
@SpringBootApplication
public class ZuulServerApplication {

	public static void main(String[] args) throws BeansException, IOException {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(ZuulServerApplication.class)
				.web(WebApplicationType.SERVLET)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		
		context.getBean(StartupCompleteEvent.class).onComplete(context);
		
	}

	@Bean
	public FallbackProvider zuulFallbackProvider() {

		return new FallbackProvider() {

			@Override
			public String getRoute() {
				return "zuul-server";
			}

			@Override
			public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

				return new ClientHttpResponse() {

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return 200;
					}

					@Override
					public String getStatusText() throws IOException {
						return "OK";
					}

					@Override
					public void close() {

					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream("fallback".getBytes());
					}

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}
					
				};

			}

		};

	}
}