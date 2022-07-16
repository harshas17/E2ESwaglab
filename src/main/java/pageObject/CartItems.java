package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartItems {
	
	public WebDriver driver;
	By cart=By.xpath("//button[@id='checkout']");
	
	public CartItems(WebDriver driver) {
		this.driver = driver;
	}
	public  WebElement getCart() {
		return driver.findElement(cart);
	}
	
}