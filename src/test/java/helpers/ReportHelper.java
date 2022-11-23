package helpers;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class ReportHelper {

    private static WebDriver driver;
    private static TakesScreenshot takesScreenshot;
    private static Scenario scenario;

    public ReportHelper(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        scenario = commonSteps.getScenario();
    }

    public static void takeScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenshot = takesScreenshot.getScreenshotAs((OutputType.BYTES));
        scenario.attach(screenshot, "image/png", "Test");
    }

    public static void log(String text) {
        scenario.log(text);
        System.out.println(text);
    }
}