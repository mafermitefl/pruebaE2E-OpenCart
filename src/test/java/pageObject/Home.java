package pageObject;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class Home extends PageObject{
	@FindBy(name = "search")
	WebElement searchInput;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	WebElement searchButton;
	
	public void abrir_pagina() {
	    open();
	}
	
	public void buscar_producto(String text) {
	    searchInput.clear();
	    searchInput.sendKeys(text);
	    searchButton.click();
	}
	
	public void abrir_producto(String productName) {
	    $(org.openqa.selenium.By.linkText(productName)).click();
	}
}
