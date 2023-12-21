package gui.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utlis.Waits;

import java.util.List;
import java.util.Objects;

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
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the typing operation.
     */
    public void type(By element, String text) {

        try {
            clear(element);
            driver.findElement(element).sendKeys(text);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to type : " + e.getMessage());
        }

    }

    /**
     * Clicks on the web element identified by the provided By selector.
     * Uses a custom wait to ensure the element is clickable before performing the click action.
     *
     * @param element The By selector identifying the web element to click.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the clicking operation.
     */
    public void click(By element) {

        try {
            Waits.waitToBeClickable(driver, element, 100);

            driver.findElement(element).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("This By element " + element + " is not clickable : " + e.getMessage());
        }

    }

    /**
     * Clears the text from the web element identified by the provided By selector.
     * Checks if the element is already empty before attempting to clear it.
     * Verifies that the element is empty after the clearing operation.
     *
     * @param element The By selector identifying the web element to clear.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the clearing operation.
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
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to clear the text field : " + e.getMessage());
        }

    }

    /**
     * Get the text content of the web element identified by the provided By selector.
     *
     * @param element The By selector identifying the web element to retrieve text from.
     * @return The text content of the web element or null if the element is empty or not found.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the getting string operation.
     */
    public String getText(By element) {

        try {
            String text = driver.findElement(element).getText();

            if (!text.isEmpty()) {
                return text;
            } else {
                throw new NoSuchElementException("Element not found : " + element);
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while getting text : " + e.getMessage());
        }

    }

    /**
     * Performs drag-and-drop action from the source element to the target element.
     *
     * @param dragElement The locator of the source element to drag.
     * @param dropElement The locator of the target element to drop onto.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the drag and drop operation.
     */
    public void dragAndDrop(By dragElement, By dropElement) {

        try {
            ElementActionsHelper.dragAndDrop(driver, dragElement, dropElement);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : ( " + (dragElement + " or " + dropElement) + " ) Unknown Locator");

        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to drag and drop elements : " + e.getMessage());
        }

    }

    /**
     * Attempts to perform a double click action on the specified web element using the ElementActionsHelper.
     * Handles cases where the element is not found or if an unexpected error occurs during the operation.
     *
     * @param element The By locator of the web element to be double-clicked.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the double-clicking operation.
     */
    public void doubleClick(By element) {

        try {
            Waits.waitToBeClickable(driver, element, 100);

            ElementActionsHelper.doubleClick(driver, element);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to double click on element : " + e.getMessage());
        }

    }

    /**
     * Attempts to get the value of the specified attribute from the given web element.
     * Handles cases where the element is not found or if an unexpected error occurs during the operation.
     *
     * @param element       The By locator of the web element.
     * @param attributeName The name of the attribute whose value is to be retrieved.
     * @return The value of the specified attribute, or null if the element is not found or an error occurs.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the getting attribute string operation.
     */
    public String getAttribute(By element, String attributeName) {

        try {
            return driver.findElement(element).getAttribute(attributeName);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to get Attribute : " + e.getMessage());
        }

    }

    /**
     * Clicks and holds on the specified element using Actions class.
     *
     * @param element The By locator of the element to click and hold.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the click and hold operation.
     */
    public void clickAndHold(By element) {

        try {
            Waits.waitToBeClickable(driver, element, 100);

            ElementActionsHelper.clickAndHold(driver, element);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to click and hold : " + e.getMessage());
        }
    }

    /**
     * Scrolls the viewport to bring the specified element into view.
     * Uses ElementActionsHelper to perform the scroll operation.
     *
     * @param element The By object representing the element to scroll to.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the scrolling operation.
     */
    public void scrollToElement(By element) {

        try {
            ElementActionsHelper.scrollToElement(driver, element);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while scrolling to element : " + e.getMessage());
        }

    }

    /**
     * Selects an item from a dropdown list by its visible text using the Select class.
     *
     * @param elements The By object representing the dropdown element.
     * @param text     The visible text of the item to be selected.
     * @throws NoSuchElementException If the specified dropdown element is not found in the DOM.
     * @throws RuntimeException       If an error occurs while selecting the item from the options.
     */
    public void select(By elements, String text) {

        try {
            WebElement webElement = driver.findElement(elements);
            var webElementsSelect = new Select(webElement);

            List<WebElement> list = webElementsSelect.getOptions();
            List<String> webElementsStringOptions = list.stream().map(WebElement::getText).toList();

            for (String string : webElementsStringOptions) {
                if (Objects.equals(string, text)) {
                    webElementsSelect.selectByVisibleText(text);
                }
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + elements);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while selecting an item from the options : " + e.getMessage());
        }

    }

    //******************* Keyboard Actions *******************//

    /**
     * Presses the Enter key on the specified WebElement identified by the given By selector.
     *
     * @param element The By selector identifying the WebElement on which to perform the action.
     * @throws NoSuchElementException If the specified element is not found in the DOM.
     * @throws RuntimeException       If an error occurs during the click enter key operation.
     */
    public void pressEnter(By element) {

        try {
            WebElement webElement = driver.findElement(element);
            actions.sendKeys(webElement, Keys.ENTER).perform();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found : " + element);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while trying to click enter : " + e.getMessage());
        }

    }

}
