Feature: Navigation

  @Navigate
  Scenario Outline:Navigate to <product> product being on <page>
    Given user is on "<page>" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    Examples:
      | page     | category      | product                 |
      | Home     | Tablets       | Samsung Galaxy Tab 10.1 |
      | Home     | Phones & PDAs | HTC Touch HD            |
      | Home     | Phones & PDAs | iPhone                  |
      | Home     | Phones & PDAs | Palm Treo Pro           |
      | Home     | Cameras       | Nikon D300              |
      | Home     | Cameras       | Canon EOS 5D            |
      | Register | Tablets       | Samsung Galaxy Tab 10.1 |
      | Register | Phones & PDAs | HTC Touch HD            |
      | Register | Phones & PDAs | iPhone                  |
      | Register | Phones & PDAs | Palm Treo Pro           |
      | Register | Cameras       | Nikon D300              |
      | Register | Cameras       | Canon EOS 5D            |
      | Login    | Tablets       | Samsung Galaxy Tab 10.1 |
      | Login    | Phones & PDAs | HTC Touch HD            |
      | Login    | Phones & PDAs | iPhone                  |
      | Login    | Phones & PDAs | Palm Treo Pro           |
      | Login    | Cameras       | Nikon D300              |
      | Login    | Cameras       | Canon EOS 5D            |

  @Navigate
  Scenario Outline:Navigate to <product> product from Featured Bar
    Given user is on "Home" page
    When user cliks on "<product>" product from Featured
    Then "<product>" product page is displayed
    Examples:
      | product      |
      | iPhone       |
      | Canon EOS 5D |
      | MacBook      |

  @Navigate
  Scenario Outline:Navigate to <product> product from Slide Bar
    Given user is on "Home" page
    When user cliks on "<product>" product from Slider
    Then "<product>" product page is displayed
    Examples:
      | product     |
      | iPhone 6    |
      | MacBook Air |

