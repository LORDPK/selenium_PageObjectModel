package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

public class CartSuite extends BaseTest {

    @Test
    public void addProducttoCart(){
        HomeMenu menu = new HomeMenu(_driver);
        ProdPage prod = new ProdPage(_driver);
        //SUPERPAGE super = new SUPERPAGE(_driver)

        menu.GoHomePage();
        menu.LoginUser("Selenium", "prueba123");

        /*
        //TODO
        super.clickLaptopcategoris();
        super.selectprodcutvaio7();
        */
        prod.addProduct();
        /*super.gotocart();
        super.vedrifyproductsINList("vaio 7");
         */
    }

    @Test
    public void sumatorioTotalesPreciosProductos(){
        HomeMenu menu = new HomeMenu(_driver);
        VistaProd vistaProd = new VistaProd(_driver);
        DetalleProducto detalleProd = new DetalleProducto(_driver);
        PageCart paginaCart = new PageCart(_driver);

        menu.GoHomePage();
        menu.LoginUser("Selenium", "prueba123");
        menu.verifyUserLogIn();

        vistaProd.ClickDetalleProducto("Samsung galaxy s6");

        detalleProd.AgregarProducto();
        detalleProd.AgregarProducto();

        paginaCart.NavUrlCart();
        paginaCart.CapturarPrecioPodructos();
        paginaCart.SumarPrecios();

        paginaCart.AssertPrecioTotal();
    }
}