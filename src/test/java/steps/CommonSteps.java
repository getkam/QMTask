package steps;

import helpers.LanguageProperties;
import helpers.ReportHelper;
import helpers.SystemProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CommonSteps {

    private WebDriver driver;
    public static Scenario scenario;
    ReportHelper report;

    @Before(order = 0)
    public void setUp(Scenario scenario) {
        System.out.println("Initializing....");
        switch (SystemProperties.getProperty("BROWSER")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        CommonSteps.scenario = scenario;
        report = new ReportHelper(this);
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
    public Scenario getScenario() {return scenario;}
}
