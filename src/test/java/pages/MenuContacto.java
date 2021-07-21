package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class MenuContacto extends BasePage{
    //By Elements
    public By botonContacto = new By.ByCssSelector("li.nav-item > a[data-target=\"#exampleModal\"]");
    public By inputEmail = new By.ById("recipient-email");
    public By inputNombre = new By.ById("recipient-name");
    public By inputMensaje = new By.ById("message-text");
    public By botonConfirmarEnvio = new By.ByCssSelector("button[onclick=\"send()\"]");

    //Contructor
    public MenuContacto(WebDriver driver) {
        super(driver);
    }

    public void contactoClick(){
        this.driver.findElement(botonContacto).click();
    }

    public void completarDatos(String email, String nombre, String mensaje){
        this.driver.findElement(inputEmail).sendKeys(email);
        this.driver.findElement(inputNombre).sendKeys(nombre);
        this.driver.findElement(inputMensaje).sendKeys(mensaje);
    }

    public void clickConfirmarEnvio(){
        this.driver.findElement(botonConfirmarEnvio).click();
    }

    public void validarRespusta(){
        String textAlerta = acceptAlert();
        Assert.assertEquals(textAlerta, "Thanks for the message!!");
    }
}
