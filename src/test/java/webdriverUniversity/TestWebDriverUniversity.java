package webdriverUniversity;

import gui.browser.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TestWebDriverUniversity {

    DriverManager driverManager = new DriverManager();

    @Test
    public void testContactUs() {

        driverManager.actions().browser().navigateToUrl("https://webdriveruniversity.com/");

        driverManager.actions().element().click(By.id("contact-us"));

        driverManager.actions().browser().switchToWindow("WebDriver | Contact Us");

        driverManager.actions().element().type(By.name("first_name"), "Mohamed");
        driverManager.actions().element().type(By.name("last_name"), "Belal");
        driverManager.actions().element().type(By.name("email"), "mohamed@gmail.com");
        driverManager.actions().element().type(By.name("message"), "Random Message");
        driverManager.actions().element().click( By.xpath("//input[contains(@type,'submit')]"));


    }


}
