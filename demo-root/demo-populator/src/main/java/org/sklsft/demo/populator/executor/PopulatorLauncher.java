package org.sklsft.demo.populator.executor;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.sklsft.generator.bash.prompt.PopulatorPrompter;
import org.sklsft.generator.bc.checker.BackupPostExecutionChecker;
import org.sklsft.generator.bc.checker.BackupPreExecutionChecker;
import org.sklsft.generator.bl.services.impl.Populator;
import org.sklsft.generator.bl.services.interfaces.ProjectLoader;
import org.sklsft.generator.bl.services.interfaces.ProjectMetaDataService;
import org.sklsft.generator.model.backup.check.BackupPlanPostExecutionWarning;
import org.sklsft.generator.model.backup.check.BackupPlanPreExecutionWarning;
import org.sklsft.generator.model.domain.Project;
import org.sklsft.generator.model.metadata.ProjectMetaData;
import org.sklsft.generator.repository.backup.datasource.interfaces.InputDataSourceProvider;
import org.sklsft.generator.repository.metadata.interfaces.ProjectMetaDataDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

public class PopulatorLauncher {

	/*
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PopulatorLauncher.class);
	
	private static final String DATASOURCE_CONTEXT_FILE ="CONTEXT" + File.separator + "datasource-context.xml";
	
	/**
	 * 
	 * @param args 0->the workspace folder where the "data-model" folder will be detected
	 * @param args 1->the folder where the backup plan will be read
	 * @param args 2(optional)->a list of semicolon separated table names if you want to restrict the population with this list
	 */
	public static void main(String[] args) {
		
		if (args.length < 2) {
			throw new IllegalArgumentException("workspace path and backup plan folder are Mandatory");
		}
		String workspacePath = args[0];
		String backupPath = args[1];
		
		String sourcePath = workspacePath + File.separator + ProjectMetaDataDao.DATA_MODEL_FOLDER_NAME;

		Set<String> tables = extractTables(args);
		
		try(FileSystemXmlApplicationContext appContext = new FileSystemXmlApplicationContext("classpath:applicationContext-demo-populator.xml",
																								"classpath:applicationContext-demo-services.xml",
																								"classpath:applicationContext-demo-business-component.xml",
																								"classpath:applicationContext-demo-repository.xml",
																								"file:" + sourcePath + File.separator + DATASOURCE_CONTEXT_FILE);){
			logger.info("Context loaded");
			
			Project project;
			
			try {
				logger.info("start loading project");
				
				ProjectMetaDataService projectMetaDataService = appContext.getBean(ProjectMetaDataService.class);
				ProjectLoader projectLoader = appContext.getBean(ProjectLoader.class);
				
				ProjectMetaData projectMetaData = projectMetaDataService.loadProjectMetaData(workspacePath);
				project = projectLoader.loadProject(projectMetaData);
				
				logger.info("loading project " + project.projectName + " completed");
					
			} catch (Exception e) {
				logger.error("failed", e);
				return;
			}
			
			try {
				
				LocalSessionFactoryBean sessionFactory = appContext.getBean(LocalSessionFactoryBean.class);
				DataSource dataSource = SessionFactoryUtils.getDataSource(sessionFactory.getObject());
												
				InputDataSourceProvider inputDataSourceProvider = appContext.getBean(InputDataSourceProvider.class);
				
				BackupPreExecutionChecker preChecker = appContext.getBean(BackupPreExecutionChecker.class);
				logger.info("Checking backup plan before execution...");
				List<BackupPlanPreExecutionWarning> preExecutionWarnings = preChecker.checkPlan(inputDataSourceProvider, project, tables, backupPath);
				logger.info("plan pre-execution check finished");
				
				PopulatorPrompter prompter = new PopulatorPrompter();
				prompter.printPreExecutionWarnings(preExecutionWarnings);
				
				logger.info("noPrompt: " + System.getProperty("noPrompt"));

				if (!Boolean.valueOf(System.getProperty("noPrompt"))) {
					prompter.promptForConfirmation();
				}
				
				Populator populator = appContext.getBean(Populator.class);
				populator.populate(inputDataSourceProvider, project, tables, backupPath);
				
				BackupPostExecutionChecker postChecker = appContext.getBean(BackupPostExecutionChecker.class);
				logger.info("Checking backup plan after execution...");
				List<BackupPlanPostExecutionWarning> postExecutionWarnings = postChecker.checkPlan(dataSource, project, tables);
				logger.info("plan post-execution check finished");
				
				prompter.printPostExecutionWarnings(postExecutionWarnings);
				
			} catch (Exception e) {
				logger.error("failed", e);
				return;
			}
		}
	}
	
	private static Set<String> extractTables(String[] args) {
		
		Set<String> tables = null;
		
		if (args.length > 2) {
			String tablesArg = args[2];
			String[] tableTokens = tablesArg.split(";");
			tables = new HashSet<String>();
			for (String table:tableTokens) {
				tables.add(table);
			}
		}
		
		return tables;
	}
}


