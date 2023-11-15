package gui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions type(By element, String text) {

        driver.findElement(element).sendKeys(text);
        return this;
    }

}
