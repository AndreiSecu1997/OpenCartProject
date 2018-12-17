Feature: Register

  @Register @Positive @Regression
  Scenario Outline: Register a new user using valid user details
    Given user is on "Home" page
    When user access the "Register" Page
    And perform register process using valid details:"<FirstName>""<LastName>""<Email>""<Telephone>""<Password>""<PrivacyPolicy>"
    Then user is on user's account page
    Examples:
      | context            | FirstName                        | LastName                         | Email  | Telephone                        | Password             | PrivacyPolicy |
      | All details        | Andrei                           | Secu                             | Random | 0685484                          | pass152              | true          |
      | FirstName32Chars   | 12541654asfssfassdafsdfsdfsadfas | Secu                             | Random | 0685484                          | pas165               | true          |
      | FirstName1Char     | a                                | Secu                             | Random | 0685484                          | cpas524              | true          |
      | LastName32Chars    | Andrei                           | 12541654asfssfassdafsdfsdfsadfas | Random | 0685484                          | pas165               | true          |
      | LastName1Char      | Andrei                           | c                                | Random | 0685484                          | cpas524              | true          |
      | Telephone32Numbers | Andrei                           | Secu                             | Random | 01234567890123456789012345678912 | pass152              | true          |
      | Telephone4Numbers  | Andrei                           | Secu                             | Random | 0123                             | pass152              | true          |
      | Password20Chars    | Andrei                           | Secu                             | Random | 0685484                          | pass0123451234512345 | true          |
      | Password4Chars     | Andrei                           | Secu                             | Random | 0685484                          | pass                 | true          |


  @Register @Negative @Regression
  Scenario Outline: User is not able to register using invalid <context>
    Given user is on "Home" page
    When user access the "Register" Page
    And perform register process using valid details:"<FirstName>""<LastName>""<Email>""<Telephone>""<Password>""<PrivacyPolicy>"
    Then user is on the "Register" page
    Examples:
      | context                    | FirstName                         | LastName                          | Email     | Telephone                         | Password              | PrivacyPolicy |
      | BlankSpaces                |                                   |                                   |           |                                   |                       | true          |
      | FirstNameMaxLength         | 12541654asfssfassdafsdfsdfsadfasd | Secu                              | Random    | 0685484                           | cpas5656              | true          |
      | FirstNameMinLength         |                                   | Secu                              | Random    | 0685484                           | cpass2345             | true          |
      | LastNameMaxLength          | Andrei                            | 12541654asfssfassdafsdfsdfsadfasd | Random    | 0685484                           | casafd312             | true          |
      | LastNameMinLength          | Andrei                            |                                   | Random    | 0685484                           | casafd312             | true          |
      | EmailFormat(.)             | Andrei                            | Secu                              | qqqq.com  | 0685484                           | casafd312             | true          |
      | EmailFormat(@)             | Andrei                            | Secu                              | qqqq@com  | 0685484                           | casafd312             | true          |
      | EmailFormat(zz@.)          | Andrei                            | Secu                              | qqqqcom@. | 0685484                           | casafd312             | true          |
      | TelephoneCharType          | Andrei                            | Secu                              | qqqqcom@. | safewwee                          | casafd312             | true          |
      | TelephoneSpecialCharacters | Andrei                            | Secu                              | qqqqcom@. | @#$##$#                           | casafd312             | true          |
      | TelephoneMaxLength         | Andrei                            | Secu                              | qqqqcom@. | 123456789123456789123456789123456 | casafd312             | true          |
      | TelephoneSMinLength        | Andrei                            | Secu                              | qqqqcom@. | 12                                | casafd312             | true          |
      | PasswordMaxLength          | Andrei                            | Secu                              | qqqqcom@. | 28455885                          | password9123345678911 | true          |
      | PasswordMinLenght          | Andrei                            | Secu                              | qqqqcom@. | 565465                            | cia                   | true          |


  @Register @Negative
  Scenario: User is not able to register using an email that was already registered
    Given user is on "Home" page
    When user access the "Register" Page
    And perform register process using valid details:"Andrei""Secu ""887wer4ty181@mail.com ""07845544 ""c123456""true"
    Then user is on the "Register" page

  @Register @Negative @Regression
  Scenario: User is not able to register without accepting Privacy Policy
    Given user is on "Home" page
    When user access the "Register" Page
    And perform register process using valid details:"Andrei""Secu ""887wer4ty181@mail.com ""07845544 ""c123456""false"
    Then an error message regarding Privacy Policy is displayed on the screen


  @Register @Negative @Regression
  Scenario: User is not able to register when the confirmation password does not match with password
    Given user is on "Home" page
    When user access the "Register" Page
    And perform register process using valid details:"Andrei""Secu ""Random""07845544 ""c123456""c544214""true"
    Then an error message regarding Password does not match is displayed on the screen




