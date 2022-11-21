package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobOfferLocators {

    WebDriver driver;

    public JobOfferLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'awsm-job-listing-item')]")
    private List<WebElement> listOfJobOffers;
    public List<WebElement> getListOfJobOffers(){return listOfJobOffers;}
    public void setListOfJobOffers(List<WebElement> listOfJobOffers) {
        this.listOfJobOffers = listOfJobOffers;};


    @FindBy(xpath = "//*[@class='awsm-job-content']")
    private WebElement jobOfferPage;
    public WebElement getJobOfferPage(){return getJobOfferPage();}
    public void setJobOfferPage(WebElement jobOfferPage) {
        this.jobOfferPage = jobOfferPage;};

    @FindBy(xpath = "//*[@id='awsm-application-submit-btn']")
    private WebElement sendButton;
    public WebElement getSendButton(){return sendButton;}
    public void setContactUsButton(WebElement sendButton) {
        this.sendButton = sendButton;};

    @FindBy(xpath = "//input[@id='awsm-applicant-name']")
    private WebElement aplicantName;
    public WebElement getAplicantName(){return aplicantName;}
    public void setAplicantName(WebElement aplicantName) {
        this.aplicantName = aplicantName;};

    @FindBy(xpath = "//div[@id='awsm-applicant-name-error']")
    private WebElement applicantNameError;
    public WebElement getApplicantNameError(){return applicantNameError;}
    public void setApplicantNameError(WebElement applicantNameError) {
        this.applicantNameError = applicantNameError;};

    @FindBy(xpath = "//input[@id='awsm-applicant-email']")
    private WebElement emailField;
    public WebElement getEmailField(){return emailField;}
    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;};

    @FindBy(xpath = "//div[@id='awsm-applicant-email-error']")
    private WebElement emailFieldError;
    public WebElement getEmailFieldError(){return emailFieldError;}
    public void setEmailFieldError(WebElement emailFieldError) {
        this.emailFieldError = emailFieldError;};

    @FindBy(xpath = "//input[@id='awsm-applicant-phone']")
    private WebElement phoneNumber;
    public WebElement getPhoneNumber(){return phoneNumber;}
    public void setPhoneNumber(WebElement phoneNumber) {
        this.phoneNumber = phoneNumber;};

    @FindBy(xpath = "//div[@id='awsm-applicant-phone-error']")
    private WebElement phoneNumberError;
    public WebElement getPhoneNumberError(){return phoneNumberError;}
    public void setPhoneNumberError(WebElement phoneNumberError) {
        this.phoneNumberError = phoneNumberError;};

    @FindBy(xpath = "//textarea[@id='awsm-cover-letter']")
    private WebElement coverLetter;
    public WebElement getCoverLetter(){return coverLetter;}
    public void setCoverLetter(WebElement coverLetter) {
        this.coverLetter = coverLetter;};

    @FindBy(xpath = "//div[@id='awsm-cover-letter-error']")
    private WebElement coverLetterError;
    public WebElement getCoverLetterError(){return coverLetterError;}
    public void setCoverLetterError(WebElement coverLetterError) {
        this.coverLetterError = coverLetterError;};

    @FindBy(xpath = "//div[@class='custom-input']")
    private WebElement attachCVButton;
    public WebElement getAttachCVButton(){return attachCVButton;}
    public void setAttachCVButton(WebElement attachCVButton) {
        this.attachCVButton = attachCVButton;};

    @FindBy(xpath = "//input[@id='awsm_form_privacy_policy']")
    private WebElement privacyPolicyCheckbox;
    public WebElement getPrivacyPolicyCheckbox(){return privacyPolicyCheckbox;}
    public void setPrivacyPolicyCheckbox(WebElement privacyPolicyCheckbox) {
        this.privacyPolicyCheckbox = privacyPolicyCheckbox;};

    @FindBy(xpath = "//div[contains(@class,'awsm-job-entry-content')]/p")
    private WebElement jobDescription;
    public WebElement getJobDescription(){return jobDescription;}
    public void setJobDescription(WebElement jobDescription) {
        this.jobDescription = jobDescription;};

    @FindBy(xpath = "//input[@id='awsm-application-file']")
    private WebElement fileCV;
    public WebElement getFileCV(){return fileCV;}
    public void setFileCV(WebElement fileCV) {
        this.fileCV = fileCV;};

    @FindBy(xpath = "//*[@class='awsm-job-form-inner']//input")
    private List<WebElement> listOfInputFields;
    public List<WebElement> getListOfInputFields(){return listOfInputFields;}
    public void setListOfInputFields(List<WebElement> listOfInputFields) {
        this.listOfInputFields = listOfInputFields;};

 }
