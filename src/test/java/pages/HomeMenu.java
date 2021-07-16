package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class HomeMenu extends BasePage{
    private String user;
    private String pass;

    //By Elements
    public By LogINMenu = new By.ById("login2");
    public By LogINUsername = new By.ById("loginusername");
    public By LogINPassword = new By.ById("loginpassword");
    public By LogINButton = new By.ByXPath("//button[text()='Log in']");
    public By usernameLogIN = new By.ById("nameofuser");
    public By LogOutButton = new By.ById("logout2");
    public By CartMenu = By.xpath("//*[text()=\"Cart\"]");

    //Contructor
    public HomeMenu(WebDriver driver) {
        super(driver);
    }

    public void GoHomePage(){
        driver.navigate().to("https://demoblaze.com/index.html");
    }

    public void LoginUser(String user, String pass)
    {
        Reporter.log("Usuario: " + user +  "Contraseña: " + pass);
        clickElement(LogINMenu);
        sendTextElement(LogINUsername, user);
        sendTextElement(LogINPassword, pass);
        clickElement(LogINButton);
        this.user = user;
        this.pass = pass;
    }

    public void LogOutUser()
    {
        clickElement(LogOutButton);
    }

    public void verifyUserLogIn()
    {
        assertElementText(usernameLogIN, "Welcome " + this.user);
    }

    public void verifyWrongPass()
    {
        String alerttext = acceptAlert();
        Assert.assertTrue(alerttext.equals("Wrong password."),"Error en el texto recuperado, se esperaba 'Wrong password.', pero se recupero '" + alerttext + "'." );
    }

    public void verifyLogOutUser(){
        waitNotVisibility(usernameLogIN);
        Assert.assertTrue(driver.findElement(usernameLogIN).getText().isEmpty(), "Error, deveria estas a blancos, Contiene : " + driver.findElement(usernameLogIN).getText());
    }

    public void GotoCart() {
        clickElement(CartMenu);
    }
}
