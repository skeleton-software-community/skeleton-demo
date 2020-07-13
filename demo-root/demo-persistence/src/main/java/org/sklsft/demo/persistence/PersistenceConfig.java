package org.sklsft.demo.persistence;

import java.util.Properties;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@Profile("server")
public class PersistenceConfig {
	
	@Inject
	private Environment env;
	
	@Inject
	private JndiTemplate jndiTemplate;

	@Bean
    public DataSource dataSource() throws NamingException {
        return jndiTemplate.lookup("java:comp/env/jdbc/demo", DataSource.class);
    }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws NamingException {
		LocalSessionFactoryBean result = new LocalSessionFactoryBean();
		
		result.setPackagesToScan("org.sklsft.demo");
		result.setDataSource(dataSource());
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.showSql"));
		result.setHibernateProperties(hibernateProperties);
		
		return result;
	}
}