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
      | page     | category      | product                 |
      | Home     | Tablets       | Samsung Galaxy Tab 10.1 |
      | Home     | Phones & PDAs | Palm Treo Pro           |
      | Home     | Cameras       | Canon EOS 5D            |
      | Register | Tablets       | Samsung Galaxy Tab 10.1 |
      | Register | Phones & PDAs | Palm Treo Pro           |
      | Register | Cameras       | Canon EOS 5D            |
      | Login    | Phones & PDAs | Palm Treo Pro           |
      | Login    | Cameras       | Nikon D300              |


