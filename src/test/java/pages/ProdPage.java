package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProdPage extends BasePage{
    //By Elements
    public By addCartButton = new By.ByCssSelector("a.btn.btn-success.btn-lg");

    //Contructor
    public ProdPage(WebDriver driver) {
        super(driver);
    }
    public void addProduct()
    {
        clickElement(addCartButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
