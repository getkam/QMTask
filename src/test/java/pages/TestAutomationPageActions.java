package pages;

import locators.TestAutomationLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import steps.CommonSteps;

public class TestAutomationPageActions extends BasePageActions {

    WebDriver driver;
    TestAutomationLocators testAutomationLocators;
    Actions actions;

    public TestAutomationPageActions(CommonSteps commonSteps) {
        super();
        this.driver = commonSteps.getDriver();
        testAutomationLocators = new TestAutomationLocators(driver);
        actions = new Actions(driver);
    }

    public boolean verifyIfContactUsButtonExists() {
        actions.scrollToElement(testAutomationLocators.getContactUsButton()).build().perform();
        return testAutomationLocators.getContactUsButton().isDisplayed();
    }

    public boolean verifyEmailAddressInContactUsButton() {
        System.out.println(testAutomationLocators.getContactUsButton().getAttribute("href"));
        return testAutomationLocators.getContactUsButton().getAttribute("href").contains("testing@qualityminds.de");
    }
}