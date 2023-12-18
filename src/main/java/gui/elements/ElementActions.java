package gui.elements;

import com.fasterxml.jackson.core.io.NumberOutput;
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
     * @param element Select the web element to type text into.
     * @param text    The text to be typed into the web element.
     */
    public void type(By element, String text) {

        clear(element);
        driver.findElement(element).sendKeys(text);
    }

    /**
     * Clicks the web element identified by the given locator after ensuring it is clickable.
     *
     * @param element Select the web element to click.
     */
    public void click(By element) {

        try {
            Waits.waitToBeClickable(driver, element, 100);

            driver.findElement(element).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("This By element" + element + "is not clickable");
        }
    }

    /**
     * Clears the content of the specified element and asserts that it is empty afterward.
     *
     * @param element The By locator of the element to be cleared.
     */
    public void clear(By element) {

        String textBeforeCheckIsEmpty = driver.findElement(element).getText();

        if (textBeforeCheckIsEmpty.isEmpty()) {
            driver.findElement(element).clear();
        }

        String textAfterCheckIsEmpty = driver.findElement(element).getText();
        Assert.assertTrue(textAfterCheckIsEmpty.isEmpty(),
                "The element is not clear. It contains text : " + textAfterCheckIsEmpty);
    }

    /**
     * Gets the text content of the specified web element.
     *
     * @param element The By locator of the web element.
     * @return The text content of the web element, or null if the element is not found or has no text.
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

    //******************* Keyboard Actions *******************//

    /**
     * Presses the Enter key on the specified WebElement identified by the given By selector.
     *
     * @param element The By selector identifying the WebElement on which to perform the action.
     */
    public void pressEnter(By element) {
        WebElement webElement = driver.findElement(element);
        actions.sendKeys(webElement, Keys.ENTER).perform();
    }

}
