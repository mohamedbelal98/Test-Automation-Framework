package gui;

import gui.browser.BrowserActions;
import gui.elements.ElementActions;
import org.openqa.selenium.WebDriver;

public class ActionsWrapper {

    private final WebDriver driver;

    public ActionsWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions browser() {
        return new BrowserActions(driver);
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }
}