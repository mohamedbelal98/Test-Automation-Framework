package gui.browser;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserActions {

    public void navigateToUrl(WebDriver driver, String url) {

        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
