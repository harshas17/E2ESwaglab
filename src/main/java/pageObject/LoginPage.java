package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By username=By.xpath("//input[@id='user-name']");
	By password=By.xpath("//input[@id='password']");
	By login=By.xpath("//input[@id='login-button']");
	By warningMessage=By.xpath("//h3[@data-test='error']");
	By errorValid=By.cssSelector("h3[data-test='error']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getUserName() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	public WebElement getError() {
		return driver.findElement(warningMessage);
	}
	public WebElement getErrorValid() {
		return driver.findElement(errorValid);
	}
}
