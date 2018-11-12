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

public class ValidateNavigationBar extends baseFile {
	public static Logger log = LogManager.getLogger(baseFile.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavBar() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}