package gui.driverFactory;

import gui.browser.BrowserActions;
import gui.elements.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utlis.ReadPropertiesFile;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private BrowserActions browserActions;
    private ElementActions elementActions;

    // Private constructor to prevent instantiation outside the class
    public DriverManager() {
        initializeDriver();
        initializeActions();
    }

    /**
     * Initializes the Selenium WebDriver based on the browser type specified in the properties file.
     * Reads the browser type from the properties file and creates the corresponding WebDriver instance.
     * Supports Chrome, Firefox, and Edge browsers.
     *
     * @throws IllegalArgumentException If an invalid browser name is provided in the properties file.
     */
    private void initializeDriver() {
        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile("src/main/resources/properties/Web.properties");

        String browser = readPropertiesFile.getBrowserType();

        switch (browser) {
            case "chrome":
                driverThreadLocal.set(new ChromeDriver());
                break;
            case "firefox":
                driverThreadLocal.set(new FirefoxDriver());
                break;
            case "edge":
                driverThreadLocal.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }

    private void initializeActions() {
        browserActions = new BrowserActions(driverThreadLocal.get());
        elementActions = new ElementActions(driverThreadLocal.get());
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public BrowserActions browser() {
        return browserActions;
    }

    public ElementActions element() {
        return elementActions;
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
    }

}