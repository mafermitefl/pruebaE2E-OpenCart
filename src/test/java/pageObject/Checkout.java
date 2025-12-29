package pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class Checkout extends PageObject {
	public void seleccionar_checkout_invitado() {
	    // Seleccionar Guest Checkout
	    $(By.cssSelector("input[name='account'][value='guest']")).click();
	    // Continuar
	    $("#button-account").click();
	}

	public void completar_datos_facturacion_invitado(String nombre, String apellido, String correo, String telefono,
            String direccion, String ciudad, String codigoPostal,
            String pais, String provincia) {

		$("#input-payment-firstname").type(nombre);
		$("#input-payment-lastname").type(apellido);
		$("#input-payment-email").type(correo);
		$("#input-payment-telephone").type(telefono);
		$("#input-payment-address-1").type(direccion);
		$("#input-payment-city").type(ciudad);
		$("#input-payment-postcode").type(codigoPostal);
		
		// País
		$("#input-payment-country").selectByVisibleText(pais);
		
		// Provincia / Región (carga dinámica)
		waitForCondition().until(driver ->
		$("#input-payment-zone").isEnabled()
		);
		$("#input-payment-zone").selectByVisibleText(provincia);
	}

    public void continuar_desde_datos_facturacion() {
        $("#button-guest").click();
    }

    public void aceptar_terminos_y_confirmar_orden() {
        if ($("#button-shipping-method").isPresent()) {
            $("#button-shipping-method").click();
        }

        $("input[name='agree']").click();
        $("#button-payment-method").click();

        $("#button-confirm").click();
    }

    public void validar_orden_confirmada() {
        $("div#content").shouldContainText("Your order has been placed!");
    }
}