Feature: Login page feature

@Login
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

@Login
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

@Login
Scenario: Login with correct credentials
Given user is on login page
When user enters username "nirifi5570@684hh.com"
And user enters password "Selenium@12345"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"

@one
Scenario: Login with all credentials
Given user is on login page
When <4> users logs in 
#Then user gets the title of the page
#And page title should be "My account - My Store"
