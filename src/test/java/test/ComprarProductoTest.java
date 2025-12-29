package test;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import steps.OpenCartSteps;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/data.csv", separator=';')

public class ComprarProductoTest {

	// Deben llamarse igual a las columnas del CSV
    public String product1;
    public String product2;

    public String nombre;
    public String apellido;
    public String correo;
    public String telefono;
    public String direccion;
    public String ciudad;
    public String codPostal;
    public String pais;
    public String provincia;

    @Steps
    OpenCartSteps steps;

    @Test
    public void Confirmar_Orden() {

        steps.open_home();

        steps.agergar_producto(product1);
        steps.agergar_producto(product2);

        steps.ver_carrito();

        steps.reemplazar_si_sin_stock(product2, "MacBook");

        steps.reemplazar_si_sin_stock(product1, "MacBook");

        steps.validar_carrito_sin_stock();

        steps.ir_checkout();

        steps.completar_datos_invitado(nombre, apellido, correo, telefono, direccion, ciudad, codPostal, pais, provincia);

        steps.confirm_order();
    }


}
