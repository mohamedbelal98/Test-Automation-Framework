package gui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utlis.Waits;


public class ElementActions {

    WebDriver driver;
    Actions actions;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    //************** Elements Actions ************//

    /**
     * @param element Select the web element to type text into.
     * @param text    The text to be typed into the web element.
     */
    public void type(By element, String text) {

        driver.findElement(element).clear();
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


    //************** Keyboard Actions ************//

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
