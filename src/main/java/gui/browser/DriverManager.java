package gui.browser;

import gui.ActionsWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utlis.ReadPropertiesFile;

public class DriverManager {

    private WebDriver driver;
    private ActionsWrapper actions;

    public DriverManager() {
        initializeDriver();
        initializeActions();
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
        actions = ActionsWrapper.getInstance(driver);
        System.out.println("#########################################################");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ActionsWrapper actions() {
        return actions;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
