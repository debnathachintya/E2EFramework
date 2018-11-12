package TestAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Academy.baseFile;
import pageObjects.LandingPage;

public class ValidateTitle extends baseFile {
	public static Logger log = LogManager.getLogger(baseFile.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void validateAppTitle() throws IOException {	
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}