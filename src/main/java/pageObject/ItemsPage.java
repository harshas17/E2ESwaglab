package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsPage {
	
	public WebDriver driver;
	By cart=By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");
	By addCart=By.xpath("//a[@class='shopping_cart_link']");
	By money=By.xpath("//div[@class='inventory_details_price']");
	By back=By.xpath("//button[@id='back-to-products']");
	
	
	public ItemsPage(WebDriver driver) {
		this.driver = driver;
	}
	public  WebElement getCart() {
		return driver.findElement(cart);
	}
	public  WebElement getAddCart() {
		return driver.findElement(addCart);
	}
	public  WebElement getMoney() {
		return driver.findElement(money);
	}
	public  WebElement getBack() {
		return driver.findElement(back);
	}
}