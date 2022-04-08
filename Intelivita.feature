Feature: Company information feature on the webpage of appliaction

Scenario: User visit the application then all the services should be displayed
Given Open the browser
When Launch the a URL
Then User should be displayed Home Page
When User goes to Company link
Then User should be displayed all the company information options

Scenario: User visit the Who We Are then all the information should be displayed
Given User is on HomePgae Company link
When User click on Who We Are link
Then User should be displayed the Who We Are Page

Scenario: User visit the How We Work then all the information should be displayed
Given User is on Who We Are Page
When User goes to Company link
And User click on How We Work link
Then User should be displayed the How We Work Page