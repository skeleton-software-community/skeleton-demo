package org.sklsft.demo.junit.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.sklsft.commons.api.exception.TechnicalError;
import org.sklsft.generator.repository.backup.command.impl.JUnitDataInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class JUnitDataInitializer {

	/*
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(JUnitDataInitializer.class);
	private boolean initialized = false;
	

	@Inject
	private JUnitDataInjector dataInjector;
	
	@Inject
	private ApplicationContext applicationContext;

	

	public void initialize() {

		if (initialized) {
			cleanDatabase();
		}

		logger.info("Initializing data");

		//call dataInjector.inject here
		
		logger.info("completed");

		initialized = true;
	}
	
	
	private void cleanDatabase() {

		DataSource dataSource = (DataSource) applicationContext.getBean(DataSource.class);

		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement();) {
			statement.execute("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT NO CHECK");
		} catch (SQLException e) {
			throw new TechnicalError(TechnicalError.ERROR_UNKNOWN, e);
		}
	}
}
