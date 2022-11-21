package locators;

import helpers.LanguageProperties;
import helpers.StepParamDiki;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePageLocators {

    WebDriver driver;

    public BasePageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id = 'top-menu']/li/a[contains(@href,'services')]")
    private WebElement topMenuServices;
    public WebElement getTopMenuServices(){return topMenuServices;}
    public void setTopMenuServices(WebElement topMenuServices){this.topMenuServices = topMenuServices;};

    @FindBy(xpath = "//*[@id = 'top-menu']/descendant::a[contains(text(),'Test Automation')]")
    private WebElement topMenuServicesTestAutomation;
    public WebElement getTopMenuServicesTestAutomation(){return topMenuServicesTestAutomation;}
    public void setTopMenuServicesTestAutomation(WebElement topMenuServicesTestAutomation) {
        this.topMenuServicesTestAutomation = topMenuServicesTestAutomation;};

    @FindBy(xpath = "//*[@id = 'top-menu']/descendant::a[contains(text(),'Automatisiertes Testen')]")
    private WebElement topMenuServicesTestAutomationDE;
    public WebElement getTopMenuServicesTestAutomationDE(){return topMenuServicesTestAutomationDE;}
    public void setTopMenuServicesTestAutomationDE(WebElement topMenuServicesTestAutomationDE) {
        this.topMenuServicesTestAutomationDE = topMenuServicesTestAutomationDE;};

    @FindBy(xpath = "//*[@id = 'top-menu']/descendant::a[contains(text(),'Events')]")
    private WebElement topMenuAboutUsEvents;
    public WebElement getTopMenuAboutUsEvents(){return topMenuAboutUsEvents;}
    public void setTopMenuAboutUsEvents(WebElement topMenuAboutUsEvents) {
        this.topMenuAboutUsEvents = topMenuAboutUsEvents;};

    @FindBy(xpath="//button[contains(@class,'cmplz-accept')]")
    private WebElement acceptAllCookiesButton;
    public WebElement getAcceptAllCookiesButton(){return acceptAllCookiesButton;}
    public void setAcceptAllCookiesButton(WebElement allCookiesButton){
        this.acceptAllCookiesButton = allCookiesButton;};

    @FindBy(xpath="//ul[@id='top-menu']/li[contains(@class, 'wpml-ls-item')]")
    private WebElement topMenuLanguageSelector;
    public WebElement getTopMenuLanguageSelector(){return topMenuLanguageSelector;}
    public void setTopMenuLanguageSelector(WebElement topMenuLanguageSelector) {
        this.topMenuLanguageSelector = topMenuLanguageSelector;};

    @FindBy(xpath="//ul[@id='top-menu']//img[@alt='DE']")
    private WebElement topMenuLanguageSelectorGerman;
    public WebElement getTopMenuLanguageSelectorGerman(){return topMenuLanguageSelectorGerman;}
    public void setTopMenuLanguageSelectorGerman(WebElement languageSelectorGerman){
        this.topMenuLanguageSelectorGerman = topMenuLanguageSelectorGerman;};
    @FindBy(xpath="//ul[@id='top-menu']//img[@alt='EN']")
    private WebElement topMenuLanguageSelectorEnglish;
    public WebElement getTopMenuLanguageSelectorEnglish(){return topMenuLanguageSelectorEnglish;}
    public void setTopMenuLanguageSelectorEnglish(WebElement languageSelectorEnglish){
        this.topMenuLanguageSelectorEnglish = topMenuLanguageSelectorEnglish;};
    @FindBy(xpath="//ul[@id='top-menu']//img[@alt='PL']")
    private WebElement topMenuLanguageSelectorPolish;
    public WebElement getTopMenuLanguageSelectorPolish(){return topMenuLanguageSelectorPolish;}
    public void setTopMenuLanguageSelectorPolish(WebElement languageSelectorPolish){
        this.topMenuLanguageSelectorPolish = topMenuLanguageSelectorPolish;};

    @FindBy(xpath="//ul[@id='top-menu']/li[contains(@class,'wpml-ls-current-language')]/a/img")
    private WebElement currentlySelectedLanguage;
    public WebElement getCurrentlySelectedLanguage(){return currentlySelectedLanguage;}
    public void setCurrentlySelectedLanguage(WebElement currentlySelectedLanguage){
        this.currentlySelectedLanguage = currentlySelectedLanguage;};

    @FindBy(xpath="//a[contains(@href,'about-us')]/parent::li[contains(@class, 'et-show-dropdown')]")
    private WebElement dropdownListAboutUs;
    public WebElement getDropdownListAboutUs(){return dropdownListAboutUs;}
    public void setDropdownListAboutUs(WebElement dropdownListAboutUs){
        this.dropdownListAboutUs = dropdownListAboutUs;};

    public WebElement getSubMenuElement (String elementName){
        return driver.findElement(By.xpath("" +
                "//*[@id = 'top-menu']/descendant::a[contains(text(),'"
                +LanguageProperties.getProperty(StepParamDiki.stepParamDiki.get(elementName))+"')]"));
    }

}