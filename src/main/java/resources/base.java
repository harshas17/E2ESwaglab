package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class base {

	protected WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver driverInitialization() throws IOException {
		
		prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName=	System.getProperty("browser");
		String browserName=prop.getProperty("browser");

		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverzs\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}
		
			 driver = new ChromeDriver(options);
			
		}
		else if (browserName.equals("firefox")) {
			//code for Firefox
		}
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\driverzs\\msedgedriver.exe");
			EdgeOptions options =new EdgeOptions();
			if(browserName.contains("headless")){
			options.addArguments("headless");
	
			}
			driver = new EdgeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;	
	
	}

	public String getScreenShotPaths(String testCaseName , WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
//test -Dbrowser=chromeheadless
