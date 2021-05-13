Feature: Login page feature

@smoketest
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

@smoketest
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

@smoketest1
Scenario: Login with correct credentials
Given user is on login page
When user enters username "nirifi5570@684hh.com"
And user enters password "Selenium"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"

@excel
Scenario: Login with all credentials
Given user is on login page
When <2> users logs in 
Then user gets the title of the page
And page title should be "Login - My Store"

@ScenarioOutline
Scenario Outline: Login with all credentials
Given user is on login page
When User enter Username as "<username>" and Password as "<password>"
Examples:
| username|password | 
| nirifi5570@684hh.com | Selenium | 
| xikafo9060@goqoez.com | Selenium |


@DataTable
Scenario: Login with all credentials
Given user is on login page
When <2> Users enters Credentials to LogIn
| nirifi5570@684hh.com | Selenium |
| xikafo9060@goqoez.com | Selenium |

