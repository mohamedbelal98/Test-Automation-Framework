package gui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utlis.Waits;


public class ElementActions {
    WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    //************** Elements Actions ************//

    /**
     * @param element Select the web element to type text into.
     * @param text    The text to be typed into the web element.
     * @return Returns the current instance of the ElementActions.
     */
    public ElementActions type(By element, String text) {

        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
        return this;
    }

    /**
     * Clicks the web element identified by the given locator after ensuring it is clickable.
     *
     * @param element Select the web element to click.
     * @return Returns the current instance of the ElementActions.
     */
    public ElementActions click(By element) {

        try {
            Waits.waitToBeClickable(driver, element, 100);

            driver.findElement(element).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("This By element" + element + "is not clickable");
        }

        return this;
    }

}
