package microservices.cloud.service.discovery;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@WebAppConfiguration
@Ignore
public class EurekaApplicationTest {

	@Value("${local.server.port}")
	private int port = 0;

	@Test
	public void catalogLoads() {

		String uri = "http://localhost:" + port;

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = 
			new TestRestTemplate("user", "password").getForEntity(uri + "/eureka/apps", Map.class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

	@Test
	public void adminLoads() {

		String uri = "http://localhost:" + port;

		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = 
			new TestRestTemplate("user", "password").getForEntity(uri + "/env", Map.class);

		assertEquals(HttpStatus.OK, entity.getStatusCode());

	}

}
