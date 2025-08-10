package pageObject;

import org.openqa.selenium.By;

public class Cart {
	
	public By btnCartContainer = By.id("shopping_cart_container");
	public By btnCheckout = By.id("checkout");
	public By txtFirstName = By.id("first-name");
	public By txtLastName = By.id("last-name");
	public By txtPostalCode = By.id("postal-code");
	public By btnContinue = By.id("continue");
	public By btnFinish = By.id("finish");
	public By msjThankYou = By.xpath("//h2[text()='Thank you for your order!']");

}
