package tests;

import org.testng.annotations.Test;
import pages.HomeMenu;
import pages.ProdPage;

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
}