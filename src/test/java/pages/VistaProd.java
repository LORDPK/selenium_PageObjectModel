package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class VistaProd extends BasePage{
    //By Elements
    public By sansungGalaxyS6 = By.linkText("Samsung galaxy s6");

    //Contructor
    public VistaProd(WebDriver driver) {
        super(driver);
    }

    public void ClickProductoSangsungGalaxyS6(){
        clickElement(sansungGalaxyS6);
    }

    public void ClickDetalleProducto(String nombreProd){
        clickElement(By.linkText(nombreProd));
    }
}
