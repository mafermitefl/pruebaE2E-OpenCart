package test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hook.Hooks;
import hook.LeerCsv;
import pageObject.Cart;
import pageObject.Login;
import pageObject.Products;

public class ComprarProductoTest extends Hooks {

	@Test
	public void TestComprarProducto() {
		List<Map<String, String>> filas = LeerCsv.readCsv("data.csv");
		for (Map<String, String> r : filas) {
			IniciarSession(r);
			AddProducto(r);
			VisualizarCarrito();
			FormularioCompra(r);
		}
	}

	public void IniciarSession(Map<String, String> r) {
		Login login = new Login();
		wait.until(ExpectedConditions.elementToBeClickable(login.User)).sendKeys(r.get("user"));
		wait.until(ExpectedConditions.elementToBeClickable(login.Password)).sendKeys(r.get("password"));
		wait.until(ExpectedConditions.elementToBeClickable(login.btnLogin)).click();
	}

	public void AddProducto(Map<String, String> r) {
		Products prod = new Products();
		wait.until(ExpectedConditions.elementToBeClickable(prod.clickbtnAdd(r.get("producto1")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(prod.clickbtnAdd(r.get("producto2")))).click();
	}

	public void VisualizarCarrito() {
		Cart cart = new Cart();
		wait.until(ExpectedConditions.elementToBeClickable(cart.btnCartContainer)).click();
	}

	public void FormularioCompra(Map<String, String> r) {
		Cart cart = new Cart();
		wait.until(ExpectedConditions.elementToBeClickable(cart.btnCheckout)).click();
		wait.until(ExpectedConditions.elementToBeClickable(cart.txtFirstName)).sendKeys(r.get("FirstName"));
		wait.until(ExpectedConditions.elementToBeClickable(cart.txtLastName)).sendKeys(r.get("LastName"));
		wait.until(ExpectedConditions.elementToBeClickable(cart.txtPostalCode)).sendKeys(r.get("PostalCode"));
		wait.until(ExpectedConditions.elementToBeClickable(cart.btnContinue)).click();
		wait.until(ExpectedConditions.elementToBeClickable(cart.btnFinish)).click();

		Assert.assertEquals(wait.until(ExpectedConditions.elementToBeClickable(cart.msjThankYou)).getText(),
				"Thank you for your order!");
	}

}
