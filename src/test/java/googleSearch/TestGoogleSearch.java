package googleSearch;

import gui.driverFactory.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utlis.ReadFromJson;

public class TestGoogleSearch {

    DriverManager driverManager = new DriverManager();
    ReadFromJson readFromJson;

    @BeforeTest
    public void beforeClass() {
        driverManager.browser().navigateToUrl("https://www.google.com.eg/");
        readFromJson = new ReadFromJson("src/test/resources/google.json");
    }

    @Test
    public void googleSearch() {

        driverManager.element().type(By.name("q"), readFromJson.getDataFromJson("Key"));
        driverManager.element().pressEnter(By.name("q"));
        driverManager.element().
                click(By.xpath("(//span[contains(text(), 'Selenium')])[1]"));

        driverManager.quitDriver();
    }

    @AfterTest
    public void tearDown() {
        driverManager.quitDriver();
    }

}
