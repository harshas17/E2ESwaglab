package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
	public WebDriver driver;
	By items=By.xpath("//div[@class='inventory_item_name']");
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	public List<WebElement> items() {
		return driver.findElements(items);
	}
}