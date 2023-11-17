package gui;

import gui.browser.BrowserActions;
import gui.elements.ElementActions;
import org.openqa.selenium.WebDriver;

public class ActionsWrapper {

    private static ActionsWrapper instance;
    private final WebDriver driver;

    // Private constructor to prevent instantiation outside the class
    private ActionsWrapper(WebDriver driver) {
        this.driver = driver;
    }

    // Public method to get the singleton instance
    public static ActionsWrapper getInstance(WebDriver driver) {
        if (instance == null) {
            synchronized (ActionsWrapper.class) {
                if (instance == null) {
                    instance = new ActionsWrapper(driver);
                }
            }
        }
        return instance;
    }

    public BrowserActions browser() {
        return new BrowserActions(driver);
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }
}
