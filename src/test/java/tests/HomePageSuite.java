package tests;

import org.testng.annotations.Test;
import pages.HomeMenu;
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
}