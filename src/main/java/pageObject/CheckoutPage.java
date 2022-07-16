package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	public WebDriver driver;
	By firstName=By.xpath("//input[@id='first-name']");
	By lastName=By.xpath("//input[@id='last-name']");
	By postal=By.xpath("//input[@id='postal-code']");
	By proceed=By.xpath("//input[@id='continue']");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	public  WebElement getFirstName() {
		return driver.findElement(firstName);
	}
	public  WebElement getLastName() {
		return driver.findElement(lastName);
	}
	public  WebElement getPostal() {
		return driver.findElement(postal);
	}
	public  WebElement getProceed() {
		return driver.findElement(proceed);
	}
}