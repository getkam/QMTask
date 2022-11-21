package pages;

import helpers.SystemProperties;
import helpers.TestHelpers;
import locators.JobOfferLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.CommonSteps;

import java.time.Duration;
import java.util.List;

public class JobOfferActions extends BasePageActions {
    WebDriver driver;
    JobOfferLocators jobOfferLocators;
    Actions actions;
    WebDriverWait wait;

    public JobOfferActions(CommonSteps commonSteps) {
        super();
        this.driver = commonSteps.getDriver();
        jobOfferLocators = new JobOfferLocators(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int numberOfJobOffers() {
        wait.until(ExpectedConditions.visibilityOfAllElements(jobOfferLocators.getListOfJobOffers()));
        return jobOfferLocators.getListOfJobOffers().size();
    }

    public void clickOnJobOffer(int index) {
        if (jobOfferLocators.getListOfJobOffers().size() > index) {
            jobOfferLocators.getListOfJobOffers().get(index).click();
        } ////////////////////////////////////////////////////////////////rzucic jakims wyjatkiem
    }

    public boolean jobOfferPageIsDisplayed() {
        sleep(1);
        return jobOfferLocators.getJobOfferPage().isDisplayed();
    }

    public void clickOnSendButton() {
        jobOfferLocators.getSendButton().click();
    }

    public void fillInputFieldWithValue(String type, String value) {
        getInputFieldByType(jobOfferLocators.getListOfInputFields(), type).sendKeys(value);

    }

    public boolean errorMessageApplicantNameIsDisplayed() {
        return jobOfferLocators.getApplicantNameError().isDisplayed();
    }

    public void enterEmojiIntoEmail() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("$('#awsm-applicant-email').val('\uD83D\uDE0A')");
        jobOfferLocators.getEmailField().sendKeys(Keys.TAB);
    }

    public String errorMessageEmailText() {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getEmailFieldError()));
        return jobOfferLocators.getEmailFieldError().getText();
    }

    public boolean errorMessageEmailIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getEmailFieldError()));
        return jobOfferLocators.getEmailFieldError().isDisplayed();
    }

    public boolean errorMessagePhoneIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getPhoneNumberError()));
        return jobOfferLocators.getPhoneNumberError().isDisplayed();
    }

    public void enterCoverLetter(String letter) {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getCoverLetter()));
        jobOfferLocators.getCoverLetter().sendKeys(letter);
    }

    public boolean errorMessageCoverLetter() {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getCoverLetterError()));
        return jobOfferLocators.getCoverLetterError().isDisplayed();
    }

    public void clickOnPrivacyPolicyCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(jobOfferLocators.getPrivacyPolicyCheckbox()));
        jobOfferLocators.getPrivacyPolicyCheckbox().click();
    }

    public boolean checkIfPrivacyPolicyIsSelected() {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getPrivacyPolicyCheckbox()));
        return jobOfferLocators.getPrivacyPolicyCheckbox().getAttribute("aria-invalid").contains("false");
    }

    public String jobDescription() {
        wait.until(ExpectedConditions.visibilityOf(jobOfferLocators.getJobDescription()));
        return jobOfferLocators.getJobDescription().getText();
    }

    public void attachTestFile() throws Exception {
        sleep(2);
        String path = TestHelpers.getPathFromWhereApplicationIsRunning()
                + SystemProperties.getProperty("REL_PATH_TO_TEST_FILE")
                + SystemProperties.getProperty("TEST_FILE");
        jobOfferLocators.getFileCV().sendKeys(path);
    }

    private WebElement getInputFieldByType(List<WebElement> listOfElements, String type) {
        for (WebElement element : listOfElements) {
            if (element.getAttribute("type").equals(type))
                return element;
        }
        return null;
    }
    public boolean attachedFileNameIsDisplayed(){

        return jobOfferLocators.getAttachCVButton().getText().contains(SystemProperties.getProperty("TEST_FILE"));
    }
}