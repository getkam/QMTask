package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventsPageLocators {
    WebDriver driver;

    public EventsPageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='tribe-events-events-bar-keyword']")
    private WebElement searchForEvents;
    public WebElement getSearchForEvents(){return searchForEvents;}
    public void setContactUsButton(WebElement searchForEvents) {
        this.searchForEvents = searchForEvents;}

    @FindBy(xpath = "//*[contains(@class,'tribe-common-c-loader__dot--third')]//li[contains(text(),'There were no results found')]")
    private WebElement noResultMessage;
    public WebElement getNoResultMessage(){return noResultMessage;}
    public void setNoResultMessage(WebElement noResultMessage) {
        this.noResultMessage = noResultMessage;}

    @FindBy(xpath = "//*[contains(@class,'tribe-events-c-top-bar__datepicker-desktop')]")
    private WebElement datePicker;
    public WebElement getDatePicker(){return datePicker;}
    public void setDatePicker(WebElement datePicker) {
        this.datePicker = datePicker;}

    @FindBy(xpath = "//*[contains(@class,'top-bar__datepicker-button-icon')]")
    private WebElement nowOnwardsArrow;
    public WebElement getNowOnwardsArrow(){return nowOnwardsArrow;}
    public void setNowOnwardsArrow(WebElement nowOnwardsArrow) {
        this.nowOnwardsArrow = nowOnwardsArrow;}

    @FindBy(xpath = "//*[contains(@class,'datepicker-dropdown')]")
    private WebElement datePickerDropdown;
    public WebElement getDatePickerDropdown(){return datePickerDropdown;}
    public void setDatePickerDropdown(WebElement datePickerDropdown) {
        this.datePickerDropdown = datePickerDropdown;}

    @FindBy(xpath = "//*[@class='datepicker-days']//th[@class='datepicker-switch']")
    private WebElement datePickerTitle;
    public WebElement getDatePickerTitle(){return datePickerTitle;}
    public void setDatePickerTitle(WebElement datePickerTitle) {
        this.datePickerTitle = datePickerTitle;}

    @FindBy(xpath = "//*[@class='datepicker-days']//th[@class='prev']")
    private WebElement datePickerPreviousMonth;
    public WebElement getDatePickerPreviousMonth(){return datePickerPreviousMonth;}
    public void setDatePickerPreviousMonth(WebElement datePickerPreviousMonth) {
        this.datePickerPreviousMonth = datePickerPreviousMonth;}

    @FindBy(xpath = "//td[@class='day past']")
    private List<WebElement> datePickerDays;
    public List<WebElement> getDatePickerDays(){return datePickerDays;}
    public void setDatePickerDays(List<WebElement> datePickerDays) {
        this.datePickerDays = datePickerDays;}

    @FindBy(xpath = "//a[contains(@class, 'tribe-events-calendar-list__event-title')]")
    private List<WebElement> listOfEvents;
    public List<WebElement> getListOfEvents(){return listOfEvents;}
    public void setListOfEvents(List<WebElement> listOfEvents) {
        this.listOfEvents = listOfEvents;}

    @FindBy(xpath = "//*[contains(@class, 'tribe-events-calendar-list__month-separator-text')]")
    private List<WebElement> listOfMonthSeparators;
    public List<WebElement> getListOfMonthSeparators(){return listOfMonthSeparators;}
    public void setListOfMonthSeparators(List<WebElement> listOfMonthSeparators) {
        this.listOfMonthSeparators = listOfMonthSeparators;}

    @FindBy(xpath = "//*[contains(@class, 'tribe-events-calendar-list__event-date-tag-daynum')]")
    private List<WebElement> listOfDayNum;
    public List<WebElement> getListOfDayNum(){return listOfDayNum;}
    public void setListOfDayNum(List<WebElement> listOfDayNum) {
        this.listOfDayNum = listOfDayNum;}
}
