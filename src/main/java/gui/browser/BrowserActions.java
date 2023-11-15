package gui.browser;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserActions {

    WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver navigateToUrl(String url) {

        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return driver;
    }

}
