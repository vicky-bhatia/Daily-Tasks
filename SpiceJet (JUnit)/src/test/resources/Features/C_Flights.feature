
Feature: C_Flightsxyz
 Scenario: Flights_Detailabc
    Given User launch chrome browser
    And User open URL "https://corporate.spicejet.com/Default.aspx"
		When User select departure city
		And User select arrival city
		And User select departure date
		And User select passenger type
    And User click on search flights
    And user select the student discount checkbox
    Then user click on continue button