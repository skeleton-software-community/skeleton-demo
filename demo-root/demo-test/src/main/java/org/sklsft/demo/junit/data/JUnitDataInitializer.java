package org.sklsft.demo.junit.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.sklsft.commons.api.exception.TechnicalError;
import org.sklsft.generator.bl.services.impl.JunitPopulator;
import org.sklsft.generator.bl.services.interfaces.ProjectLoader;
import org.sklsft.generator.bl.services.interfaces.ProjectMetaDataService;
import org.sklsft.generator.model.domain.Project;
import org.sklsft.generator.model.metadata.ProjectMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JUnitDataInitializer {

	/*
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(JUnitDataInitializer.class);
	
	
	private boolean initialized = false;
	private Project project;
	
	@Inject
	private JunitPopulator populator;
	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private ProjectMetaDataService projectMetaDataService;
	
	@Inject
	private ProjectLoader projectLoader;

	

	public void initialize(String... packages) {

		if (initialized) {
			cleanDatabase();
		} else {			
			logger.info("start loading project");
			ProjectMetaData projectMetaData = projectMetaDataService.loadProjectMetaData("..");
			project = projectLoader.loadProject(projectMetaData);
			logger.info("loading project " + project.projectName + " completed");
		}

		logger.info("Initializing data");
		Set<String> packs = new HashSet<>(Arrays.asList(packages));		
		populator.populate(project, packs, "src/test/resources/junit/data");		
		logger.info("completed");

		initialized = true;
	}
	
	
	private void cleanDatabase() {

		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement();) {
			statement.execute("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT NO CHECK");
		} catch (SQLException e) {
			throw new TechnicalError(TechnicalError.ERROR_UNKNOWN, e);
		}
	}
}
