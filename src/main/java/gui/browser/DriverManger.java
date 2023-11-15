package gui.browser;

import utlis.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManger {

    WebDriver driver;

    public WebDriver initializeDriver() {

        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile("src/main/resources/properties/Web.properties");

        String browser = readPropertiesFile.getBrowserType();

        System.out.println(browser);

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

        driver.manage().window().fullscreen();
        return driver;
    }

}
