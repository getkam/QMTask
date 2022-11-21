package pages;

import locators.EventsPageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.CommonSteps;

import java.time.Duration;

public class EventsPageActions extends BasePageActions {

    WebDriver driver;
    EventsPageLocators eventsPageLocators;
    Actions actions;
WebDriverWait wait;
    private String datePickerSelection;

    public EventsPageActions(CommonSteps commonSteps) {
        super();
        this.driver = commonSteps.getDriver();
        eventsPageLocators = new EventsPageLocators(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchForEvents(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(eventsPageLocators.getSearchForEvents()));
        eventsPageLocators.getSearchForEvents().sendKeys(searchText);
        eventsPageLocators.getSearchForEvents().sendKeys(Keys.ENTER);
    }

    public boolean noResultMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(eventsPageLocators.getNoResultMessage()));
        return eventsPageLocators.getNoResultMessage().isDisplayed();
    }

    public boolean datePickerNoSelection() {
        wait.until(ExpectedConditions.visibilityOf(eventsPageLocators.getDatePicker()));
        return eventsPageLocators.getDatePicker().getText().equals("Now onwards");
    }

    public boolean datePickerCheckSelection() {
        return eventsPageLocators.getDatePicker().getText().equals(datePickerSelection);
    }

    public boolean datePickerDropdownIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(eventsPageLocators.getDatePickerDropdown()));
        return eventsPageLocators.getDatePickerDropdown().isDisplayed();
    }

    public void clickOnNowOnwardsArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(eventsPageLocators.getNowOnwardsArrow()));
        eventsPageLocators.getNowOnwardsArrow().click();
    }

    public void navigateToDate(int day, String month, String year) {
        String monthYear = month + " " + year;
        datePickerSelection = month + " " + day + ", " + year + " onwards";
        System.out.println("From test data: " + monthYear);
        System.out.println("From date picker: " + eventsPageLocators.getDatePickerTitle().getText());
        while (!eventsPageLocators.getDatePickerTitle().getText().equals(monthYear)) {
            eventsPageLocators.getDatePickerPreviousMonth().click();
        }
        wait.until(ExpectedConditions.elementToBeClickable( eventsPageLocators.getDatePickerDays().get(day - 1)));

        eventsPageLocators.getDatePickerDays().get(day - 1).click();
    }
    public String getTitleOfFirstEvent(){
        wait.until(ExpectedConditions.visibilityOfAllElements(eventsPageLocators.getListOfEvents()));
        return eventsPageLocators.getListOfEvents().get(0).getText();
    }
    public String getFirstMonthSeparator(){
        wait.until(ExpectedConditions.visibilityOfAllElements(eventsPageLocators.getListOfMonthSeparators()));
        return eventsPageLocators.getListOfMonthSeparators().get(0).getText();
    }
    public String getDayNumOfFirstEvent(){
        wait.until(ExpectedConditions.visibilityOfAllElements(eventsPageLocators.getListOfDayNum()));
        return eventsPageLocators.getListOfDayNum().get(0).getText();
    }
}