Feature: Login

  @Login @Regression
  Scenario: Log in the system using valid credentials
    Given user is on "Home" page
    When user access the "Login" Page
    And perform login process using valid credentials
    Then user is on user's account page

  @LoginNegative @Regression
  Scenario Outline: Log in the system using invalid <key>
    Given user is on "Home" page
    When user access the "Login" Page
    And perform login process using invalid "<key>"
    Then on the screen appears an error message
    Examples:
      | key             |
      | InvalidEmail    |
      | InvalidPassword |




