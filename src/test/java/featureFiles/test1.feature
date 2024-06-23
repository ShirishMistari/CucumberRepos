Feature: Login to the rahulShetty WebSite
  As a student i want to loginto the rahuls website

  Scenario: User login page
    Given I am on the login page of the website
    When I fills username and password
    And I selects radio button and accept popup alert
    And I select option from dropdon
    Then I click on SignIn button after selecting checkbox

  Scenario: Check testing of iFrames
    Given I am on the login page of demo website
    When I logs into application
    And I hover on "SwitchTo" name
    And I click on "Frames" option
    And I click on iframe button
    And I enter "IframeDemo" into input field
    Then I should be navigated back to the default frame
