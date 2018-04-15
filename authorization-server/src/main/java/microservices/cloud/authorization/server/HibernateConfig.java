package microservices.cloud.authorization.server;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import microservices.cloud.authorization.server.model.Authorities;
import microservices.cloud.authorization.server.model.User;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("microservices.cloud.authorization.server.dao"),
		@ComponentScan("microservices.cloud.authorization.server.service") })
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		Properties hibernateProp = new Properties();

		// Setting JDBC properties
		hibernateProp.put(DRIVER, env.getProperty("mysql.driver"));
		hibernateProp.put(URL, env.getProperty("mysql.jdbcUrl"));
		hibernateProp.put(USER, env.getProperty("mysql.username"));
		hibernateProp.put(PASS, env.getProperty("mysql.password"));

		// Setting Hibernate properties
		hibernateProp.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		hibernateProp.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

		// Setting C3P0 properties
		hibernateProp.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		hibernateProp.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		hibernateProp.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		hibernateProp.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		hibernateProp.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

		sessionFactory.setHibernateProperties(hibernateProp);
		sessionFactory.setAnnotatedClasses(User.class, Authorities.class);

		return sessionFactory;

	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
