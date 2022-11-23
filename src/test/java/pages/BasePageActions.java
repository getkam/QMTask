package pages;

import helpers.LanguageProperties;
import helpers.StepParamDiki;
import locators.BasePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.CommonSteps;

import java.time.Duration;

public class BasePageActions {
    private WebDriver driver;
    WebDriverWait wait;
    CommonSteps commonSteps;
    BasePageLocators basePageLocators;
    Actions actions;
    io.cucumber.java.Scenario scenario;

    public BasePageActions(CommonSteps commonSteps) {
        this.driver = commonSteps.getDriver();
        basePageLocators = new BasePageLocators(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public BasePageActions() {

    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void hoverOverTopMenuItem(String topMenuItem) {
        wait.until(ExpectedConditions.visibilityOf(basePageLocators.getTopMenuLanguageSelector()));
        actions.moveToElement(driver.findElement
                (By.linkText(LanguageProperties.getProperty
                        (StepParamDiki.stepParamDiki.get(topMenuItem))))).build().perform();
    }

    public void hoverOverLanguageSelector() {
        wait.until(ExpectedConditions.visibilityOf(basePageLocators.getTopMenuLanguageSelector()));
        actions.moveToElement(basePageLocators.getTopMenuLanguageSelector()).build().perform();
    }

    public void selectLanguage(String expectedLanguage) {
        switch (expectedLanguage) {
            case "German":
                wait.until(ExpectedConditions.elementToBeClickable(basePageLocators.getTopMenuLanguageSelectorGerman()));
                actions.click(basePageLocators.getTopMenuLanguageSelectorGerman()).perform();
                LanguageProperties.setCurrentLanguage(expectedLanguage);
                break;
            case "English":
            default:
                wait.until(ExpectedConditions.elementToBeClickable(basePageLocators.getTopMenuLanguageSelectorEnglish()));
                actions.click(basePageLocators.getTopMenuLanguageSelectorEnglish()).perform();
                LanguageProperties.setCurrentLanguage(expectedLanguage);
                break;
        }
    }

    public void clickOnSubMenuItem(String linkName) {
        wait.until(ExpectedConditions.visibilityOf
                (basePageLocators.getSubMenuElement(linkName)));
        actions.click(basePageLocators.getSubMenuElement(linkName)).build().perform();
    }

    public void clickOnEvents() {
        actions.click(basePageLocators.getTopMenuAboutUsEvents()).perform();
    }

    public void closeCookies() {
        if (basePageLocators.getAcceptAllCookiesButton().isDisplayed())
            basePageLocators.getAcceptAllCookiesButton().click();
    }

    public void sleep(int sec) {  //debug helper
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkSelectedLanguageSelector(String language) {
        wait.until(ExpectedConditions.visibilityOf(basePageLocators.getCurrentlySelectedLanguage()));
        switch (language) {
            case "German":
                return basePageLocators.getCurrentlySelectedLanguage().getAttribute("src").contains("de.png");
            default:
            case "English":
                System.out.println(basePageLocators.getCurrentlySelectedLanguage().getAttribute("src"));
                return basePageLocators.getCurrentlySelectedLanguage().getAttribute("src").contains("en.png");
        }
    }

    public boolean checkVisibilityOfDropdown() {
        wait.until(ExpectedConditions.visibilityOf(basePageLocators.getDropdownListAboutUs()));
        return basePageLocators.getDropdownListAboutUs().isDisplayed();
    }
}