package tests;

import org.testng.annotations.Test;
import pages.HomeMenu;

public class LogINSuite extends BaseTest {

    @Test
    public void correctUserLogIn(){
        HomeMenu menu = new HomeMenu(_driver);

        menu.GoHomePage();
        menu.LoginUser("Selenium", "prueba123");
        menu.verifyUserLogIn();
    }
 
    @Test
    public void wrongUserPasswordLogIN(){
        HomeMenu menu = new HomeMenu(_driver);

        menu.GoHomePage();
        menu.LoginUser("Selenium", "badpass");
        menu.verifyWrongPass();
    }

    @Test
    public void correctUserLogOut(){
        HomeMenu menu = new HomeMenu(_driver);

        menu.GoHomePage();
        menu.LoginUser("Selenium", "prueba123");
        menu.LogOutUser();

        menu.verifyLogOutUser();
    }
}