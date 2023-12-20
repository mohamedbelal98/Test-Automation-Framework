package webdriverUniversity;

import gui.driverFactory.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import utlis.ReadFromJson;
import utlis.Waits;

import java.util.List;

import static org.testng.Assert.*;


public class TestWebDriverUniversity {

    DriverManager driverManager;
    ReadFromJson readFromJson;

    @BeforeMethod
    public void beforeMethod() {
        driverManager = new DriverManager();
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

        List<WebElement> list = driverManager.getDriver().findElements(By.xpath("//*[@id='container']/ul/child::li/span/i"));
        Actions actions = new Actions(driverManager.getDriver());
        System.out.println(list.size());

        for (WebElement webElement : list) {
            actions.moveToElement(webElement).click().perform();
        }

    }

    @Test
    public void testClickAccordionLink() {

        driverManager.element().click(By.xpath("//h1[contains(text(), 'ACCORDION & TEXT AFFECTS (APPEAR & DISAPPEAR)' )]/parent::div"));

        driverManager.browser().switchToWindow("Accordion Items");

        driverManager.element().click(By.id("manual-testing-accordion"));
        driverManager.element().click(By.id("cucumber-accordion"));
        driverManager.element().click(By.id("automation-accordion"));

        WebElement webElement = driverManager.getDriver().findElement(By.id("hidden-text"));

        Waits.waitStrategyTextPresent(driverManager.getDriver(), webElement,
                "LOADING COMPLETE.", 20);

        driverManager.element().click(By.id("click-accordion"));

        assertEquals(driverManager.element().getText(By.id("timeout")),
                "This text has appeared after 5 seconds!");
    }

    @Test
    public void testActions() {

        driverManager.element().click(By.id("actions"));

        driverManager.browser().switchToWindow("WebDriver | Actions");

        driverManager.element().dragAndDrop(By.id("draggable"), By.id("droppable"));
        assertEquals(driverManager.element().getText(By.xpath("//div[@id='droppable']/p/child::b"))
                , "Dropped!");

    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }

}
