package org.sklsft.demo.junit;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sklsft.demo.junit.data.JUnitDataInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-demo-test.xml" })
public class SetupTest {

	/*
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SetupTest.class);
	
	@Inject
	private JUnitDataInitializer dataInitializer;

	
	@Before
	public void setUp() {
		dataInitializer.initialize();		
	}
	
	
	@Test
	public void testSetup() {		
		logger.info("Your test environment is ready to use !");			
	}
}
