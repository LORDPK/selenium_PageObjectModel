package tests;

import org.testng.Reporter;
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
        Reporter.log("Inicia la ejecucion de sumatorioTotalesPreciosProductos");

        HomeMenu menu = new HomeMenu(_driver);
        VistaProd vistaProd = new VistaProd(_driver);
        DetalleProducto detalleProd = new DetalleProducto(_driver);
        PageCart paginaCart = new PageCart(_driver);

        Reporter.log("Dado me logue correctamente en demoblaze");
        menu.GoHomePage();
        menu.LoginUser("Selenium", "prueba123");
        menu.verifyUserLogIn();

        Reporter.log("Y agrego dos productos en mi carrito");
        vistaProd.ClickDetalleProducto("Samsung galaxy s6");

        detalleProd.AgregarProducto();
        detalleProd.AgregarProducto();

        Reporter.log("Y Me encuentro en la pagina www.demoblaze.com/cart.html");
        menu.GotoCart();

        Reporter.log("Cuando Controlo el precio de cada producto en la columna Price");
        paginaCart.CapturarPrecioProductos();

        Reporter.log("Y sumó todos los valores");
        paginaCart.SumarPrecios();

        Reporter.log("Entonces el monto que figura debajo de Total debería ser igual al de la suma de valores");
        paginaCart.AssertPrecioTotal();
    }
}