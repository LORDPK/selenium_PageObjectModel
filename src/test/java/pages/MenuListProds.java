package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MenuListProds extends BasePage{
    @FindBy(xpath = "//a[text()='Phones']")
    WebElement menuPhones;
    @FindBy(xpath = "//a[text()='Monitors']")
    WebElement menuMonitors;
    @FindBy(xpath = "//h4[@class='card-title']/a[text()='Sony xperia z5']")
    WebElement itemSonyXperia;

    //Contructor
    public MenuListProds(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void clickMenuPhones()
    {
        waitVisibility(menuPhones);
        menuPhones.click();
    }

    public void clickmenuMonitors()
    {
        waitVisibility(menuMonitors);
        menuMonitors.click();
    }

    public void clickitemSonyXperia()
    {
        waitVisibility(itemSonyXperia);
        itemSonyXperia.click();
    }
}
