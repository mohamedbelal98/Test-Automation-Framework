package googleSearch;

import base.BaseTest;
import gui.browser.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleSearch extends BaseTest {

    BrowserActions browserActions = new BrowserActions();

    @Test
    public void googleSearch() {

        browserActions.navigateToUrl(driver, "https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.ENTER);
    }

}
