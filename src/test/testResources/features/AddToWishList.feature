Feature: Add product to Wish List

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


