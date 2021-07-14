package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PageCart extends BasePage{
    private List<WebElement> listaPrecios;
    private int totalPrecios = 0;
    //By Elements
    public By preciosProductos = By.cssSelector("tbody#tbodyid > tr.success > td:nth-child(3)");
    public By preciosTotal = By.id("totalp");

    //Contructor
    public PageCart(WebDriver driver) {
        super(driver);
    }

    public void NavUrlCart() {
        driver.navigate().to("https://www.demoblaze.com/cart.html");
    }

    public void CapturarPrecioPodructos() {
        waitVisibility(preciosProductos);
        this.listaPrecios = driver.findElements(preciosProductos);
    }
    
    public void SumarPrecios() {
        for (WebElement web : listaPrecios) {
            this.totalPrecios = this.totalPrecios + Integer.parseInt(web.getText());
        }
    }

    public void AssertPrecioTotal() {
        waitVisibility(preciosTotal);
        int totalPantalla = Integer.parseInt(driver.findElement(preciosTotal).getText());
        Assert.assertEquals(totalPantalla, totalPrecios, "Error,Los totales de precios no Coinciden");
    }
}
