package DemoSwagLab;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resources.base;

public class LoginValidation extends base {
	WebDriver driver;
	private static Logger log=LogManager.getLogger(LoginValidation.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		driver = driverInitialization();
		log.info("driver is initialized");
	}

	@Test(dataProvider = "getData")

	public void loginValidation(String Username, String Password, String Text) throws IOException {
		driver.get(prop.getProperty("url"));
		LoginPage lg = new LoginPage(driver);
		lg.getUserName().sendKeys(Username);
		lg.getPassword().sendKeys(Password);
		lg.getLogin().click();
		if(driver.getPageSource().contains(lg.getErrorValid().getText())) {
		Assert.assertTrue(true);
	}
		else {
			Assert.assertTrue(false);
		}
		log.info("Eroor message validation");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser is closed");
	}

	@DataProvider
	public Object[][] getData() {
		// Rows Stands for how many different data types test should run
//column stands for how many values per each test
		Object[][] data = new Object[3][3];
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		data[0][2] = "non restricteduser";

		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";
		data[1][2] = "restricteduser";
		
		data[2][0] = "standard_user";
		data[2][1] = "secret_sauce";
		data[2][2] = "non restricteduser";

		return data;
	}

}
