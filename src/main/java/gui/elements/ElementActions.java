package gui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

}
