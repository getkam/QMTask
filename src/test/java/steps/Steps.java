package steps;

import helpers.LanguageProperties;
import helpers.ReportHelper;
import helpers.StepParamDiki;
import helpers.SystemProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Steps {
    BasePageActions basePageActions;
    LandingPageActions landingPageActions;
    TestAutomationPageActions testAutomationPageActions;
    EventsPageActions eventsPageActions;
    JobOfferActions jobOfferActions;


    public Steps(BasePageActions basePageActions,
                 LandingPageActions landingPageActions,
                 TestAutomationPageActions testAutomationPageActions,
                 EventsPageActions eventsPageActions,
                 JobOfferActions jobOfferactions) {
        this.basePageActions = basePageActions;
        this.landingPageActions = landingPageActions;
        this.testAutomationPageActions = testAutomationPageActions;
        this.eventsPageActions = eventsPageActions;
        this.jobOfferActions = jobOfferactions;
    }

    @Given("^I have (.*) opened$")
    @When("^I navigate to (.*)$")
    public void i_have_page_opened(String page) {
        LanguageProperties.setCurrentLanguage("English");
        if (page.equals("Job Offers page")) LanguageProperties.setCurrentLanguage("German");
        ReportHelper.takeScreenShot();
        basePageActions.goToUrl(SystemProperties.getProperty(StepParamDiki.stepParamDiki.get(page)));
        ReportHelper.log("Web site opened");
        basePageActions.closeCookies();
    }

/*    @When("I navigate to main page")
    public void i_navigate_to_main_page() {
        basePageActions.goToUrl(SystemProperties.getProperty("URL_MAIN_PAGE"));
        LanguageProperties.setCurrentLanguage("English");
    }*/

    @When("^I hover over (.*)$")
    public void i_hover_over_top_menu_item(String topMenuItem) {
        basePageActions.hoverOverTopMenuItem(topMenuItem);
    }

    @When("^I select (.*) link from sub menu$")
    public void i_select_link_from_sub_menu(String linkName) {
        basePageActions.clickOnSubMenuItem(linkName);
    }

    @When("^I select (.*) language version$")
    public void i_select_language_version(String language) {
        basePageActions.hoverOverLanguageSelector();
        basePageActions.sleep(2);
        basePageActions.selectLanguage(language);
    }

    @Then("^I see (.*) language selector$")
    public void i_see_expected_language_version(String language) {
        assertThat(basePageActions.checkSelectedLanguageSelector(language)).isTrue();
    }

    @Then("^I am on the (.*)$")
    public void i_am_on_the_page(String page) {
        assertThat(basePageActions.getCurrentPageTitle())
                .contains(LanguageProperties.getProperty(StepParamDiki.stepParamDiki.get(page)));
    }

    @Then("^I want to see (.*) version of the page$")
    public void i_want_to_see_expected_language_version_of_the_page(String expectedLang) {
        ReportHelper.log("Expected is "+ expectedLang + " language version.");
        assertThat(LanguageProperties.getCurrentLanguage()).isEqualTo(expectedLang);
        assertThat(basePageActions.getCurrentPageUrl()).contains
                (SystemProperties.getProperty(StepParamDiki.stepParamDiki.get(expectedLang)));
        ReportHelper.log("Language version is matching");
    }

    @Then("I see Contact Us button exist")
    public void i_see_contact_us_button_exist() {
        assertThat(testAutomationPageActions.verifyIfContactUsButtonExists()).isTrue();
        ReportHelper.log("\"Contact us\" button exists");
    }

    @Then("Contact Us button links to correct e-mail")
    public void contact_us_button_links_to_correct_e_mail() {
        assertThat(testAutomationPageActions.verifyEmailAddressInContactUsButton()).isTrue();
        ReportHelper.log("\"Contact us\" button leads to correct e-mail");
    }

    @Then("I see sub menu")
    public void i_see_sub_menu() {
        assertThat(basePageActions.checkVisibilityOfDropdown()).isTrue();
        ReportHelper.log("Sub-menu is displayed");
    }

    @When("I click on Events")
    public void i_click_on_events() {
        basePageActions.clickOnEvents();
    }

    @When("^I search (.*)$")
    public void i_search(String searchText) {
        eventsPageActions.searchForEvents(searchText);
    }

    @Then("I see no-result message")
    public void i_see_no_result_message() {
        assertThat(eventsPageActions.noResultMessageIsDisplayed()).isTrue();
        ReportHelper.log("\"No Result\" message is displayed");
    }

    @Then("I see Now onwards")
    public void i_see_now_onwards() {
        assertThat(eventsPageActions.datePickerNoSelection()).isTrue();
        ReportHelper.log("\"Now Onwards\" button displayed");
    }

    @When("I click on Now onwards arrow")
    public void i_click_on_now_onwards_arrow() {
        eventsPageActions.clickOnNowOnwardsArrow();
    }

    @Then("Calendar is displayed")
    public void calendar_is_displayed() {
        assertThat(eventsPageActions.datePickerDropdownIsDisplayed()).isTrue();
        ReportHelper.log("Date picker is diplayed");
    }

    @When("^I navigate to (.*)-(.*)-(.*)$")
    public void i_navigate_to_date(int day, String month, String year) {
        eventsPageActions.navigateToDate(day, month, year);
    }

    @Then("Selected date is displayed")
    public void selected_date_is_displayed() {
        eventsPageActions.datePickerCheckSelection();
    }

    @Then("^I see (.*) event$")
    public void i_see_expected_event(String eventName) {
        assertThat(eventsPageActions.getTitleOfFirstEvent()).contains(eventName);
        ReportHelper.log("Expected event: \""+eventName+"\" is displayed");
    }

    @Then("^I see that event date is (.*)-(.*)-(.*)$")
    public void i_see_that_event_date_is(String day, String month, String year) {
        assertThat(eventsPageActions.getFirstMonthSeparator()).isEqualTo(month + " " + year);
        assertThat(eventsPageActions.getDayNumOfFirstEvent()).isEqualTo(day);
        ReportHelper.log("Event day is as expected: " + day +" "+month+" "+year);
    }

    @Then("I see more than one offer")
    public void i_see_more_than_one_offer() {
        assertThat(jobOfferActions.numberOfJobOffers()).isGreaterThanOrEqualTo(1);
        ReportHelper.log("There is at least one job offer available");
    }

    @When("I click on first offer")
    public void i_click_on_first_offer() {
        jobOfferActions.clickOnJobOffer(0);
    }

    @Then("I want to be on the offer page")
    public void i_want_to_be_on_the_offer_page() {
        //assertThat(jobOfferActions.jobOfferPageIsDisplayed()).isTrue();
    }

    @When("I click on Send button")
    public void i_click_on_send_button() {
        jobOfferActions.clickOnSendButton();
    }

    @Then("I see required field error messages for all input fields")
    public void i_see_field_required_messages_for_input_fields() {
        assertThat(jobOfferActions.errorMessageApplicantNameIsDisplayed()).isTrue();
        assertThat(jobOfferActions.errorMessageEmailIsDisplayed()).isTrue();
        assertThat(jobOfferActions.errorMessageEmailText()).isEqualTo(LanguageProperties.getProperty("FIELD_REQUIRED"));
        assertThat(jobOfferActions.errorMessagePhoneIsDisplayed()).isTrue();
        assertThat(jobOfferActions.errorMessageCoverLetter()).isTrue();
        ReportHelper.log("Error messages are displayed for empty input fields");
    }

    @When("^I fill (.*) with (.*)$")
    public void i_fill_field_with_value(String field, String value) {
        jobOfferActions.fillInputFieldWithValue(StepParamDiki.stepParamDiki.get(field), value);
    }

    @Then("I see invalid value error message for Email")
    public void i_see_not_valid_message_for_email() {
        assertThat(jobOfferActions.errorMessageEmailText()).isEqualTo(LanguageProperties.getProperty("INVALID_VALUE"));
        ReportHelper.log("Error message \"Invalid value\" is displayed for field E-mail after entering emoji");
    }

    @When("I fill Bewerbungsschreiben")
    public void i_fill_bewerbungsschreiben() {
        String[] str = jobOfferActions.jobDescription().split(" ");
        String finalText = str[0] + " ";
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                continue;
            finalText += str[i] + " ";
        }
        jobOfferActions.enterCoverLetter(finalText);
    }

    @Then("I see validation message disapeared")
    public void i_see_validation_message_disapeared() {

    }

    @When("I attach Resume")
    public void i_attach_resume() {
        //jobOfferActions.clickOnLoadCV();
        try {
            jobOfferActions.attachTestFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I see file Name displayed")
    public void i_see_file_name_displayed() {
        assertThat(jobOfferActions.attachedFileNameIsDisplayed()).isTrue();
    }

    @When("I check checkbox Datenschutzerklarung")
    public void i_check_checkbox_datenschutzerklarung() {
        jobOfferActions.clickOnPrivacyPolicyCheckbox();
    }

    @Then("I see chebox is checked")
    public void i_see_chebox_is_checked() {
        assertThat(jobOfferActions.checkIfPrivacyPolicyIsSelected()).isTrue();
        ReportHelper.log("Privacy policy consent checkbox is checked");
    }

    @When("I enter emoji into Email")
    public void iEnterEmojiIntoEmail() {
        jobOfferActions.enterEmojiIntoEmail();
    }

    @Then("I see no error message for Vorname und Nachname field")
    public void iSeeNoErrorMessageForVornameUndNachnameField() {
        assertThat(jobOfferActions.errorMessageApplicantNameIsDisplayed()).isFalse();
        ReportHelper.log("Error message for First Name and Surname disapeard after entering value");
    }
}