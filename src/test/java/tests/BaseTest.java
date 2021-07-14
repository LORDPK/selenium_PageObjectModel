package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utility.GetScreenshot;

import java.io.IOException;
import java.time.Duration;

public class BaseTest implements ITestListener {
    protected WebDriver _driver;
    protected ChromeOptions options;

    @BeforeClass
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
        options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("incognito");
        options.addArguments("start-maximized");
        //options.addArguments("window-size=1400,600");
    }

    @BeforeMethod
    public void beforeTest(){
        _driver = new ChromeDriver(options);
        _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("ERROR FATAL");
            try
            {
                String path = GetScreenshot.capture(_driver, result.getName());
                Reporter.log("<br><img src='" + path + "'/></b>", true);
            }
            catch (IOException e)
            {
                Reporter.log(e.getMessage());
            }
        }

        if(_driver != null)
        {
            _driver.close();
            _driver.quit();
        }
    }
}