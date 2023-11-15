package base;

import gui.browser.DriverManger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void startDriver() {

        driver = new DriverManger().initializeDriver();

    }

//    @AfterMethod
//    public void quitDriver() {
//        driver.quit();
//    }

}
