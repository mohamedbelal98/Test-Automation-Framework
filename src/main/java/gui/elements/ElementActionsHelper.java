package gui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActionsHelper {

    /**
     * Performs a drag-and-drop action from the source element to the target element using the Actions class.
     *
     * @param driver The WebDriver instance to perform the action.
     * @param source The locator of the source element to drag.
     * @param target The locator of the target element to drop onto.
     */
    public static void dragAndDrop(WebDriver driver, By source, By target) {

        WebElement sourceElement = driver.findElement(source);
        WebElement targetElement = driver.findElement(target);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    /**
     * Performs a double click action on the web element located by the given By locator.
     * Utilizes the Actions class in Selenium WebDriver to execute the double click operation.
     *
     * @param driver  The WebDriver instance controlling the browser.
     * @param element The By locator of the web element to be double-clicked.
     */
    public static void doubleClick(WebDriver driver, By element) {

        WebElement webElement = driver.findElement(element);

        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).perform();
    }

    /**
     * Clicks and holds on the specified element using Actions class in a static manner.
     *
     * @param driver  The WebDriver instance to perform the action.
     * @param element The By locator of the element to click and hold.
     */
    public static void clickAndHold(WebDriver driver, By element) {

        WebElement webElement = driver.findElement(element);

        Actions actions = new Actions(driver);
        actions.clickAndHold(webElement).perform();
    }

    /**
     * Scrolls the viewport to bring the specified element into view using the Actions class.
     *
     * @param driver  The WebDriver instance used to interact with the browser.
     * @param element The By object representing the element to scroll to.
     */
    public static void scrollToElement(WebDriver driver, By element) {

        WebElement webElement = driver.findElement(element);

        Actions actions = new Actions(driver);
        actions.scrollToElement(webElement).perform();
    }


}
