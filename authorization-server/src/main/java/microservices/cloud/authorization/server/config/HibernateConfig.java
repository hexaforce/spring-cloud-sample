package microservices.cloud.authorization.server.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
  
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory sessionFactory() {
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
	
}
