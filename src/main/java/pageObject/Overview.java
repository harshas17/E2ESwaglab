package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Overview {
	
	public WebDriver driver;
	By finish=By.xpath("//button[@id='finish']");
	
	public Overview(WebDriver driver) {
		this.driver = driver;
	}
	public  WebElement getFinish() {
		return driver.findElement(finish);
	}
}