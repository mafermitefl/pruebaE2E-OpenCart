package pageObject;

import org.openqa.selenium.By;

public class Products {
	
	public By btnAddtoCard;
	
	public By clickbtnAdd(String producto) {
		btnAddtoCard = By.xpath("//button[contains(@id,'"+ producto.toLowerCase().replace(" ", "-") +"')]");
		return btnAddtoCard;
	}

}
