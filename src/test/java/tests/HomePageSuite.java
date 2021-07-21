package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.HomeMenu;
import pages.MenuContacto;
import pages.MenuListProds;

public class HomePageSuite extends BaseTest {

    @Test
    public void selectItemSonyXperia(){
        HomeMenu menu = new HomeMenu(_driver);
        MenuListProds home = new MenuListProds(_driver);

        menu.GoHomePage();
        home.clickmenuMonitors();
        home.clickMenuPhones();
        home.clickitemSonyXperia();
    }

    @Test
    public void enviarMensaje(){
        MenuContacto menuCont = new MenuContacto(_driver);
        HomeMenu menu = new HomeMenu(_driver);

        Reporter.log("Dado Que ingresó a la página de www.demoblaze.com sin estar logueado");

        Reporter.log("Cuando Hago click en Contact en el Menu Superior");
        menuCont.contactoClick();

        Reporter.log("Y En el modal ingreso Contact email, Contact Name y Message");
        menuCont.completarDatos("prueba@prueba.com", "Jony", "Estoy interezado en su lista de productos");

        Reporter.log("Y Hago click en Send Message");
        menuCont.clickConfirmarEnvio();

        Reporter.log("Entonces Se mostrara una alerta informando 'Thanks for the message!!'");
        menuCont.validarRespusta();
    }

}