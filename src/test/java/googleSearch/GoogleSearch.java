package googleSearch;

import gui.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleSearch {

    DriverManager driverManager = new DriverManager();

    @Test
    public void googleSearch() {

        driverManager.actions().browser().navigateToUrl("https://www.google.com.eg/");
        driverManager.actions().element().type(By.name("q"), "Selenium");
        driverManager.getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
        driverManager.actions().element().
                click(By.xpath("(//span[contains(text(), 'Selenium')])[1]"));

        driverManager.quitDriver();
    }

}
