package gui.browser;

import gui.elements.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utlis.ReadPropertiesFile;

public class DriverManager {

    private static DriverManager instance;
    private WebDriver driver;
    private BrowserActions browserActions;
    private ElementActions elementActions;

    // Private constructor to prevent instantiation outside the class
    public DriverManager() {
        initializeDriver();
        initializeActions();
    }

    // Public method to get the singleton instance
    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    private void initializeDriver() {
        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile("src/main/resources/properties/Web.properties");

        String browser = readPropertiesFile.getBrowserType();

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }

    private void initializeActions() {
        browserActions = new BrowserActions(driver);
        elementActions = new ElementActions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserActions browser() {
        return browserActions;
    }

    public ElementActions element() {
        return elementActions;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}