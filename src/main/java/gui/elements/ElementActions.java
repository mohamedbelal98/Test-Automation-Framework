package gui.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utlis.Waits;

public class ElementActions {

    WebDriver driver;
    Actions actions;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    //******************* Elements Actions *******************//

    /**
     * Types the given text into the specified element after clearing its existing content.
     *
     * @param element The By locator of the web element to type into.
     * @param text    The text to be typed into the element.
     */
    public void type(By element, String text) {

        try {
            clear(element);
            driver.findElement(element).sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found : " + element);
        } catch (Exception e) {
            System.out.println("An error occurred while trying to type: " + e.getMessage());
        }

    }

    /**
     * Clicks on the web element identified by the provided By selector.
     * Uses a custom wait to ensure the element is clickable before performing the click action.
     *
     * @param element The By selector identifying the web element to click.
     */
    public void click(By element) {

        try {
            Waits.waitToBeClickable(driver, element, 100);

            driver.findElement(element).click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found : " + element);
        } catch (Exception e) {
            System.out.println("This By element" + element + "is not clickable");
        }

    }

    /**
     * Clears the text from the web element identified by the provided By selector.
     * Checks if the element is already empty before attempting to clear it.
     * Verifies that the element is empty after the clearing operation.
     *
     * @param element The By selector identifying the web element to clear.
     */
    public void clear(By element) {

        try {
            String textBeforeCheckIsEmpty = driver.findElement(element).getText();
            if (textBeforeCheckIsEmpty.isEmpty()) {
                driver.findElement(element).clear();
            }
            String textAfterCheckIsEmpty = driver.findElement(element).getText();
            Assert.assertTrue(textAfterCheckIsEmpty.isEmpty(),
                    "The element is not clear. It contains text : " + textAfterCheckIsEmpty);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found : " + element);
        } catch (Exception e) {
            System.out.println("An error occurred while trying to clear the text field : " + e.getMessage());
        }

    }

    /**
     * Get the text content of the web element identified by the provided By selector.
     *
     * @param element The By selector identifying the web element to retrieve text from.
     * @return The text content of the web element or null if the element is empty or not found.
     */
    public String getText(By element) {

        try {
            String text = driver.findElement(element).getText();

            if (!text.isEmpty()) {
                return text;
            } else {
                System.out.println("This element is empty:" + element);
                return null;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found : " + element);
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred while getting text: " + e.getMessage());
            return null;
        }

    }

    /**
     * Performs drag-and-drop action from the source element to the target element.
     *
     * @param dragElement The locator of the source element to drag.
     * @param dropElement The locator of the target element to drop onto.
     */
    public void dragAndDrop(By dragElement, By dropElement) {

        try {
            ElementActionsHelper.dragAndDrop(driver, dragElement, dropElement);
        } catch (NoSuchElementException e) {
            if (e.getMessage().contains("Unable to locate element")) {
                System.out.println("Element not found: (" + (dragElement + " or " + dropElement) + ") Unknown Locator");
                Assert.fail();
            } else {
                System.out.println("An error occurred while trying to drag and drop elements: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    //******************* Keyboard Actions *******************//

    /**
     * Presses the Enter key on the specified WebElement identified by the given By selector.
     *
     * @param element The By selector identifying the WebElement on which to perform the action.
     */
    public void pressEnter(By element) {

        try {
            WebElement webElement = driver.findElement(element);
            actions.sendKeys(webElement, Keys.ENTER).perform();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found : " + element);
        } catch (Exception e) {
            System.out.println("An error occurred while trying to click enter: " + e.getMessage());
        }

    }

}
