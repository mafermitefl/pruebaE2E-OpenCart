package pageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class Products extends PageObject {
	
	//*[@id="cart"]/button
	
	public void agregar_al_carrito() {
		$(By.cssSelector("button#button-cart")).click();
    }
    
    public void ir_al_carrito_desde_menu_superior() {
        $(By.cssSelector("span#cart-total")).click();
        $(By.cssSelector("p.text-right a[href*='route=checkout/cart']")).click();
    }

}
