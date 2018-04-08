package microservices.cloud.auth.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.security.Principal;

@RestController
@EnableResourceServer
@EnableAuthorizationServer
@Slf4j
@SpringBootApplication
public class AuthServerApplication {

	static {

		// for localhost testing only
		log.warn("Will now disable hostname check in SSL, only to be used during development");
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

	}

	public static void main(String[] args) {

		SpringApplication.run(AuthServerApplication.class, args);

	}

	@RequestMapping("/user")
	public Principal user(Principal user) {

		return user;

	}

}
