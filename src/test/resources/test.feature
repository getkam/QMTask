Feature: Code Challenge
  Scenario: Test1
    Given I have Main page opened
    When I select German language version
    Then I want to see German version of the page
    When I hover over Portfolio
    And I select Automatisiertes Testen link from sub menu
    Then I am on the Automatisiertes Testen page
    And I see Contact Us button exist
    And Contact Us button links to correct e-mail
    When I navigate to main page
    Then I want to see English version of the page
    When I hover over Services
    And I select Test Automation link from sub menu
    Then I am on the Test Automation page
    When I select German language version
    Then I am on the Automatisiertes Testen page


  Scenario: Test2
    Given I have Main page opened
    Then I see English language selector
    When I hover over About us
    Then I see sub menu
    When I click on Events
    Then I am on the Events page
    When I search 2021
    Then I see no-result message
    And I see Now onwards
    When I click on Now onwards arrow
    Then Calendar is displayed
    When I navigate to 31-December-2021
    Then Selected date is displayed
    And I see ICSTTP 2021 event
    And I see that event date is 04-JANUARY-2022


    Scenario: Test3
      Given I have Job Offers page opened
      Then I am on the Stellenangebote page
      And I see more than one offer
      When I click on first offer
      Then I want to be on the offer page
      When I click on Send button
      Then I see required field error messages for all input fields
      When I fill Vorname und Nachname with Magdalena Getka
      Then I see no error message for Vorname und Nachname field
      When I enter emoji into Email
      Then I see invalid value error message for Email
      When I fill Bewerbungsschreiben
      Then I see validation message disapeared
      When I attach Resume
      Then I see file Name displayed
      When I check checkbox Datenschutzerklarung
      Then I see chebox is checked





