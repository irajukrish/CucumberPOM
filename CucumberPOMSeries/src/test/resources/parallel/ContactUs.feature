Feature: Contact Us feature

@ContactUs
Scenario: Contact us page title
Given User is on Contact us page
When Send a message
Then Confirmation message