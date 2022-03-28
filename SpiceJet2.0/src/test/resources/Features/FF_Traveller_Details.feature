
Feature: Feature to test traveller details

  Background:
    Given User launch chrome browser
    And User open URL "https://corporate.spicejet.com/Default.aspx"
		When User select departure city
		And User select arrival city
		And User select departure date
		And User select passenger type
    And User click on search flights
    And user select the student discount checkbox
    Then user click on continue button
    
  Scenario: Traveller_Detail
    Given User is on traveller detail page
    And user enter first name
    And user enter last name
    And user enter Mobile Number
    And user enter email ID
    When user selects the i am flying checkbox
    And user enter the student ID
    And user clicks on continue button
    And user clicks on continue
    And user selects his seat
    Then user clicks continue to payment page