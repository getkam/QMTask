package steps;

import helpers.LanguageProperties;
import helpers.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CommonSteps {

    private WebDriver driver;

    @Before(order = 0)
    public void setUp() {
        System.out.println("Initializing....");
        switch (SystemProperties.getProperty("BROWSER")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        LanguageProperties.setCurrentLanguage("English");
    }

    @After(order = 1)
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
