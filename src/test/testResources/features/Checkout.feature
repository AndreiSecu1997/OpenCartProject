Feature: Checkout
@Checkout
  Scenario Outline:Buy the available <product> product
    Given user is on "Home" page
    When user cliks on "<product>" product from Featured
    Then "<product>" product page is displayed
    When user adds "1" units to cart
    And user access the "Cart" Page
    When user access the "Checkout" Page
    And perform buy using the following details:"andrei.secu1997@gmail.com","qwerty123"
  Then checkout is done successfully

    Examples:
      | product |
      | iPhone  |