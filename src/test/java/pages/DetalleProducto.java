package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetalleProducto extends BasePage{
    //By Elements
    public By addCartButton = By.linkText("Add to cart");

    //Contructor
    public DetalleProducto(WebDriver driver) {
        super(driver);
    }

    public void AgregarProducto(){
        clickElement(addCartButton);
        acceptAlert();
    }
}
