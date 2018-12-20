Feature: Compare Product

  @Regression
  Scenario Outline: Add one <product> product to comparison list
    Given user is on "<page>" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user clicks on Compare button
    Then the "<product>" product is added to Comparison List
    Examples:
      | page | category      | product                 |
      | Home | Tablets       | Samsung Galaxy Tab 10.1 |
      | Home | Phones & PDAs | Palm Treo Pro           |

  @Regression
  Scenario Outline: Add 2 products to comparison list
    Given user is on "<page>" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    When user clicks on Compare button
    And user clicks on "<category2>" category
    Then "<category2>" category page is displayed
    When user cliks on "<product2>" product
    Then "<product2>" product page is displayed
    When user clicks on Compare button
    Then the "<product>" product is added to Comparison List
    And the "<product2>" product is added to Comparison List
    Examples:
      | page | category | category2     | product                 | product2      |
      | Home | Tablets  | Phones & PDAs | Samsung Galaxy Tab 10.1 | HTC Touch HD |
