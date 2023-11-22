package webdriverUniversity;

import gui.driverFactory.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utlis.ReadFromJson;


public class TestWebDriverUniversity {

    DriverManager driverManager = new DriverManager();
    ReadFromJson readFromJson = new ReadFromJson("src/test/resources/webDriverUniversityData.json");

    @Test
    public void testContactUs() {

        driverManager.browser().navigateToUrl("https://webdriveruniversity.com/");

        driverManager.element().click(By.id("contact-us"));

        driverManager.browser().switchToWindow("WebDriver | Contact Us");

        driverManager.element().type(By.name("first_name"), readFromJson.getDataFromJson("firstName"));
        driverManager.element().type(By.name("last_name"), readFromJson.getDataFromJson("lastName"));
        driverManager.element().type(By.name("email"), readFromJson.getDataFromJson("email"));
        driverManager.element().type(By.name("message"), readFromJson.getDataFromJson("message"));

        driverManager.element().click(By.xpath("//input[contains(@type,'submit')]"));

        driverManager.quitDriver();

    }


}
