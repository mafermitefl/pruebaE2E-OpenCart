package steps;

import net.serenitybdd.annotations.Step;
import pageObject.Cart;
import pageObject.Checkout;
import pageObject.Home;
import pageObject.Products;

public class OpenCartSteps {
	
	Home homePage;
    Products productPage;
    Cart cartPage;
    Checkout checkoutPage;

    @Step("Abrir home")
    public void open_home() {
        homePage.abrir_pagina();
    }

    @Step("Agregar producto al carrito: {0}")
    public void agergar_producto(String productName) {
        homePage.buscar_producto(productName);
        homePage.abrir_producto(productName);
        productPage.agregar_al_carrito();
    }

    @Step("Ver carrito")
    public void ver_carrito() {
        productPage.ir_al_carrito_desde_menu_superior();
    }

    @Step("Validar productos en carrito")
    public void validar_productos(String p1, String p2) {
        cartPage.validar_producto_en_carrito(p1);
        cartPage.validar_producto_en_carrito(p2);
    }

    @Step("Ir a checkout")
    public void ir_checkout() {
        cartPage.ir_a_checkout();
    }

    @Step("Checkout como invitado y completar datos")
    public void completar_datos_invitado(String firstName, String lastName, String email, String telephone,
                               String address1, String city, String postcode, String country, String region) {
        checkoutPage.seleccionar_checkout_invitado();
        checkoutPage.completar_datos_facturacion_invitado(firstName, lastName, email, telephone, address1, city, postcode, country, region);
        checkoutPage.continuar_desde_datos_facturacion();
    }

    @Step("Confirmar compra")
    public void confirm_order() {
        checkoutPage.aceptar_terminos_y_confirmar_orden();
        checkoutPage.validar_orden_confirmada();
    }
    
    @Step("Si el producto está sin stock, reemplazar por uno alterno")
    public void reemplazar_si_sin_stock(String productName, String fallbackProduct) {
        // Si hay alert rojo o aparece *** en la tabla, quitamos y reemplazamos
        if (cartPage.tiene_alerta_sin_stock() || cartPage.carrito_tiene_marca_sin_stock()) {
            cartPage.eliminar_producto_por_nombre(productName);

            // Volver a home y agregar el fallback
            homePage.abrir_pagina();
            agergar_producto(fallbackProduct);

            // Volver a carrito para continuar el flujo
            ver_carrito();
        }
    }
    
    @Step("Validar que el carrito no tenga productos sin stock (***)")
    public void validar_carrito_sin_stock() {
    	cartPage.validar_carrito_sin_sin_stock();
    }

}
