package microservices.cloud.config.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigServerApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
// Instruct embedded Tomcat to run on a random free port and skip talking to the Bus and the Discovery server
//@IntegrationTest({ "server.port=0", "spring.cloud.bus.enabled=false", "spring.cloud.discovery.enabled=false" })
public class ConfigServerApplicationTest {

	@Test
	public void contextLoads() {

	}

}

