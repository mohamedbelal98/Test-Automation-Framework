package gui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActionsHelper {

    public static void dragAndDrop(WebDriver driver, By source, By target) {

        WebElement sourceElement = driver.findElement(source);
        WebElement targetElement = driver.findElement(target);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

}
