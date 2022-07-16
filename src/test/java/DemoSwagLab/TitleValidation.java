package DemoSwagLab;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.CartItems;
import pageObject.CheckoutPage;
import pageObject.FinalPage;
import pageObject.ItemsPage;
import pageObject.LoginPage;
import pageObject.Overview;
import pageObject.ProductsPage;
import resources.base;

public class TitleValidation extends base {
	WebDriver driver;
	private static Logger log=LogManager.getLogger(TitleValidation.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		driver = driverInitialization();
		log.info("driver is initialized");

	}

	@Test(dataProvider = "getData")

	public void endTitleVerification(String Username, String Password, String Text) throws IOException {
		driver.get(prop.getProperty("url"));
		LoginPage lg = new LoginPage(driver);
		lg.getUserName().sendKeys(Username);
		lg.getPassword().sendKeys(Password);
		lg.getLogin().click();
		ProductsPage pg = new ProductsPage(driver);
		List<WebElement> options = (List<WebElement>) pg.items();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equalsIgnoreCase(prop.getProperty("search"))) {
				options.get(i).click();
				break;
			}

		}
		ItemsPage ip=new ItemsPage(driver);
		ip.getCart().click();
		ip.getAddCart().click();
		
		CartItems ci=new CartItems(driver);
		ci.getCart().click();
		
		CheckoutPage cp=new CheckoutPage(driver);
		cp.getFirstName().sendKeys(prop.getProperty("firstname"));
		cp.getLastName().sendKeys(prop.getProperty("lastname"));
		cp.getPostal().sendKeys(prop.getProperty("postalcode"));
		cp.getProceed().click();
		
	
		Overview o=new Overview(driver);
		o.getFinish().click();
		
		FinalPage fp=new FinalPage(driver);
		String Actual=fp.getText().getText();
		
		Assert.assertEquals(Actual, prop.getProperty("accepted"));
		log.info("Title verification");
		

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
		
		data[1][0] = "performance_glitch_user";
		data[1][1] = "secret_sauce";
		data[1][2] = "non restricteduser";
		
	;
		return data;
	}

}
