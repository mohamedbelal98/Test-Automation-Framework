package webdriverUniversity;

import gui.driverFactory.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utlis.ReadFromJson;


public class TestWebDriverUniversity {

    DriverManager driverManager = new DriverManager();
    ReadFromJson readFromJson;

    @BeforeTest
    public void beforeTest() {
        driverManager.browser().navigateToUrl("https://webdriveruniversity.com/");
        readFromJson = new ReadFromJson("src/test/resources/webDriverUniversityData.json");
    }

    @Test
    public void testContactUs() {

        driverManager.element().click(By.id("contact-us"));

        driverManager.browser().switchToWindow("WebDriver | Contact Us");

        driverManager.element().type(By.name("first_name"), readFromJson.getDataFromJson("ContactUs.firstName"));
        driverManager.element().type(By.name("last_name"), readFromJson.getDataFromJson("ContactUs.lastName"));
        driverManager.element().type(By.name("email"), readFromJson.getDataFromJson("ContactUs.email"));
        driverManager.element().type(By.name("message"), readFromJson.getDataFromJson("ContactUs.message"));

        driverManager.element().click(By.xpath("//input[contains(@type,'submit')]"));

        driverManager.quitDriver();
    }

    @Test
    public void testToDoList() {

        driverManager.element().click(By.id("to-do-list"));

        driverManager.browser().switchToWindow("WebDriver | To Do List");

        driverManager.element().type(By.xpath("//input[@type='text']"), "New Item to list");
        driverManager.element().pressEnter(By.xpath("//input[@type='text']"));

    }

    @AfterTest
    public void tearDown() {
        driverManager.quitDriver();
    }

}
