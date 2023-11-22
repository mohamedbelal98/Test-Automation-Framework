package webdriverUniversity;

import gui.browser.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TestWebDriverUniversity {

    DriverManager driverManager = new DriverManager();

    @Test
    public void testContactUs() {

        driverManager.browser().navigateToUrl("https://webdriveruniversity.com/");

        driverManager.element().click(By.id("contact-us"));

        driverManager.browser().switchToWindow("WebDriver | Contact Us");

        driverManager.element().type(By.name("first_name"), "Mohamed");
        driverManager.element().type(By.name("last_name"), "Belal");
        driverManager.element().type(By.name("email"), "mohamed@gmail.com");
        driverManager.element().type(By.name("message"), "Random Message");
        driverManager.element().click(By.xpath("//input[contains(@type,'submit')]"));

        driverManager.quitDriver();

    }


}
