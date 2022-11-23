package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestAutomationLocators {

    WebDriver driver;

    public TestAutomationLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class,'et_pb_button')]/a")
    private WebElement contactUsButton;
    public WebElement getContactUsButton(){return contactUsButton;}
    public void setContactUsButton(WebElement contactUsButton) {
        this.contactUsButton = contactUsButton;}
}