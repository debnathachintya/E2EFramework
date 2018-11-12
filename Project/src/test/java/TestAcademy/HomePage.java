package TestAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.baseFile;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends baseFile {
	public static Logger log = LogManager.getLogger(baseFile.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String passWord) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(passWord);
		
		log.info("Entered Username & Password");
		
		lp.getLogin().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		// 0th Row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";

		// 1st Row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "45678";

		return data;
	}
}