package googleSearch;

import gui.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleSearch {

    DriverManager driverManager = new DriverManager();

    @Test
    public void googleSearch() {

        driverManager.browser().navigateToUrl("https://www.google.com.eg/");
        driverManager.element().type(By.name("q"), "Selenium");
        driverManager.getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
        driverManager.element().
                click(By.xpath("(//span[contains(text(), 'Selenium')])[1]"));

        driverManager.quitDriver();
    }

}
