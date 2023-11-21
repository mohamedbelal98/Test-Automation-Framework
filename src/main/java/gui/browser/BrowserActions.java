package gui.browser;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.NoSuchElementException;
import java.util.Set;

public class BrowserActions {

    WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates the web browser to the specified URL and asserts that the current URL matches the expected URL.
     *
     * @param url The URL to navigate to.
     */
    public void navigateToUrl(String url) {

        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void switchToWindow(String windowsTitle) {

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(windowsTitle)) {
                return;
            }
        }
        throw new NoSuchElementException("Windows with title : " + windowsTitle + "not found");

    }

}
