Feature:Add Product To Cart
#  As a user I want to add a specific product to cart so that I will be able to buy it.

  @Regression
  Scenario Outline: Add a valid unit's quantity of a <product> to cart
    Given user is on "Login" page
    And perform login process using valid credentials
    Then user is on user's account page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user adds "<quantity>" units to cart
    Then an success message appears on the screen
    When user access the "Cart" Page
    Then "<quantity>" units of "<product>" were added to cart
    Examples:
      | category      | product                            | quantity |
      | Computers     | AnewProduct                        | 5        |
      | Desktops      | camera                             | 4        |

  @Regression
  Scenario Outline: Login and add a valid unit's quantity of a <product> to cart
    Given user is on "Home" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user adds "<quantity>" units to cart
    Then an success message appears on the screen
    When user access the "Cart" Page
    Then "<quantity>" units of "<product>" were added to cart
    Examples:
      | category      | product                            | quantity |
      | Computers     | AnewProduct                        | 7        |
      | Desktops      | camera                             | 4        |


  @Regression
  Scenario Outline: Login and add an invalid units number of a <product> to cart
    Given user is on "Login" page
    And perform login process using valid credentials
    Then user is on user's account page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user adds "<quantity>" units to cart
    And user access the "Cart" Page
    Then "<product>" product is not found on Category page
    Examples:
      | category      | product                            | quantity          |
      | Computers     | AnewProduct                        | 0                 |
      | Computers     | MyProduct                          | 12356452342342132 |
      | Computers     | NMProduct                          | zzzzz             |
      | Desktops      | camera                             | @#@#$#            |
      | Desktops      | Change thermal paste for processor | </input>          |
      | Desktops      | camera                             | ASDSDAS           |
      | Mobile Phones | Change thermal paste for processor | -24               |


  @Regression
  Scenario Outline: Add an invalid units number of a <product> to cart
    Given user is on "Register" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user adds "<quantity>" units to cart
    And user access the "Cart" Page
    Then "<product>" product is not found on Category page
    Examples:
      | category      | product                            | quantity          |
      | Computers     | AnewProduct                        | 0                 |
      | Computers     | MyProduct                          | 12356452342342132 |
      | Computers     | NMProduct                          | zzzzz             |
      | Desktops      | camera                             | @#@#$#            |
      | Desktops      | Change thermal paste for processor | </input>          |
      | Mobile Phones | Change thermal paste for processor |                   |
      | Desktops      | camera                             | ASDSDAS           |
      | Mobile Phones | Change thermal paste for processor | -24               |
      | Desktops      | camera                             | 14+1              |



