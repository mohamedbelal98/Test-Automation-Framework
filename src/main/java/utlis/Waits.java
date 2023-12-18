package utlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static void waitToBeClickable(WebDriver driver, By element, int durationInSeconds) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitToBeSelected(WebDriver driver, By element, int durationInSeconds) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        webDriverWait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitToBeClickableAndSelected(WebDriver driver, By element, int durationInSeconds) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        webDriverWait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(element),
                ExpectedConditions.elementToBeSelected(element)
        ));
    }

    public static void waitStrategyTextPresent(WebDriver driver, WebElement element, String text, int durationInSeconds) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
