Feature: Add product to Wish List

  @WishList
  Scenario Outline: Login and add <product> product to wish list
    Given user is on "<page>" page
    When user access the "Login" Page
    And perform login process using valid credentials
    Then user is on user's account page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user clicks on AddToWishList button
    And user access the "WishList" Page
    Then the "<product>" product is added to Wish List
    Examples:
      | page     | category  | product                            |
      | Home     | Computers | camera                             |
      | Home     | Desktops  | Change thermal paste for processor |
      | Register | Computers | camera                             |
      | Register | Desktops  | Change thermal paste for processor |


  @WishList
  Scenario Outline: Add <product> product to wish list
    Given user is on "<page>" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user clicks on AddToWishList button
    Then on the page is displayed a success message

    Examples:
      | page     | category  | product                            |
      | Home     | Computers | camera                             |
      | Register   | Desktops  | Change thermal paste for processor |
      | Register | Computers | camera                             |


