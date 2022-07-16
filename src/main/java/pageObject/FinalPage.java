package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalPage {
	
	public WebDriver driver;
	By text=By.xpath("//h2[normalize-space()='THANK YOU FOR YOUR ORDER']");
	
	public FinalPage(WebDriver driver) {
		this.driver = driver;
	}
	public  WebElement getText() {
		return driver.findElement(text);
	}
}