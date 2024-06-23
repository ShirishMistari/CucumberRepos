Feature: As a Rahul Shetty Academy student I want to login to the application

Scenario Outline: Login to the application with multiple users
Given I launch Chrome
And I navigate to the login page
When I enter "<Email>" and "<Password>"
Then I should be navigated to the home page

Examples:
     |    Email           | Password   |
     |Sm123@gmail.com     | Chetna!123 |
     |Sona1@gmail.com     | D@12345    |
     |gurudas123@gmail.com| King@123   |
  
     
     
   