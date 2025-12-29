package pageObject;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class Cart extends PageObject {
	
//	public By btnCartContainer = By.id("shopping_cart_container");
//	public By btnCheckout = By.id("checkout");
//	public By txtFirstName = By.id("first-name");
//	public By txtLastName = By.id("last-name");
//	public By txtPostalCode = By.id("postal-code");
//	public By btnContinue = By.id("continue");
//	public By btnFinish = By.id("finish");
//	public By msjThankYou = By.xpath("//h2[text()='Thank you for your order!']");
//	
	private final By alertDanger = By.cssSelector(".alert.alert-danger");
	private final By cartTable   = By.cssSelector("div.table-responsive");

    public void validar_producto_en_carrito(String productName) {
        $(cartTable).shouldContainText(productName);
    }

    public void ir_a_checkout() {
        $(By.cssSelector("a.btn.btn-primary[href*='route=checkout/checkout']")).click();
    }
    
	public boolean tiene_alerta_sin_stock() {
	    return $(alertDanger).isPresent()
	            && $(alertDanger).getText().contains("Products marked with ***");
	}
	
	public boolean carrito_tiene_marca_sin_stock() {
	    return $(cartTable).isPresent()
	            && $(cartTable).getText().contains("***");
	}
	
	public boolean carrito_contiene_producto(String productName) {
	    return $(cartTable).isPresent()
	            && $(cartTable).getText().contains(productName);
	}
	
	public void eliminar_producto_por_nombre(String productName) {
	    $(By.xpath(
	        "//table[contains(@class,'table')]//a[normalize-space()='" +
	        productName +
	        "']/ancestor::tr//button[contains(@class,'btn-danger')]"
	    )).click();
	}
	
	public void validar_carrito_sin_sin_stock() {
	    $(cartTable).shouldNotContainText("***");
	    if ($(alertDanger).isPresent()) {
	        $(alertDanger).shouldNotContainText("Products marked with ***");
	    }
    }
}