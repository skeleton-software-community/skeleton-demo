package org.sklsft.demo.services;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ServicesConfig {

	@Inject
	private SessionFactory sessionFactory;
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager result = new HibernateTransactionManager();
		result.setSessionFactory(sessionFactory);
		return result;
	}
}
