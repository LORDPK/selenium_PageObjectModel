package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Wait Element is Visible
    public void waitVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //Wait Element not is Visible
    public void waitNotVisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //Click
    public void clickElement(By locator) {
        waitVisibility(locator);
        driver.findElement(locator).click();
    }

    //SendKey
    public void sendTextElement(By locator, String text) {
        waitVisibility(locator);
        driver.findElement(locator).sendKeys(text);
    }

    //SendKey
    public void assertElementText(By locator, String text) {
        waitVisibility(locator);
        String textElement = driver.findElement(locator).getText();
        Assert.assertTrue(textElement.equals(text), "Error en el texto recuperado, se esperaba '" + text + "', pero se recupero '" + textElement + "'.");
    }    
}