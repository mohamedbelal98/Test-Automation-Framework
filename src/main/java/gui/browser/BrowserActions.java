package gui.browser;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserActions {

    WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates the web browser to the specified URL and asserts that the current URL matches the expected URL.
     *
     * @param url The URL to navigate to.
     * @return Returns the current instance of the WebDriver.
     */
    public WebDriver navigateToUrl(String url) {

        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return driver;
    }

}
