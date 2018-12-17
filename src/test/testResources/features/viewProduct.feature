Feature: Navigation

  @fdfb
  Scenario Outline:Navigate to <product> product being on <page>
    Given user is on "<page>" page
    When user clicks on "<category>" category
    Then "<category>" category page is displayed
    When user cliks on "<product>" product
    Then "<product>" product page is displayed
    Examples:
      | page     | category      | product                            |
      | Home     | Computers     | camera                             |
      | Home     | Computers     | AnewProduct                        |
      | Home     | Computers     | MyProduct                          |
      | Home     | Computers     | NMProduct                          |
      | Home     | Desktops      | camera                             |
      | Home     | Desktops      | Change thermal paste for processor |
      | Home     | Mobile Phones | Change thermal paste for processor |
      | Home     | Desktops      | camera                             |
      | Register | Computers     | camera                             |
      | Register | Computers     | AnewProduct                        |
      | Register | Computers     | MyProduct                          |
      | Register | Computers     | NMProduct                          |
      | Register | Desktops      | camera                             |
      | Register | Desktops      | Change thermal paste for processor |
      | Register | Mobile Phones | Change thermal paste for processor |
      | Register | Desktops      | camera                             |
      | Login    | Computers     | camera                             |
      | Login    | Computers     | AnewProduct                        |
      | Login    | Computers     | MyProduct                          |
      | Login    | Computers     | NMProduct                          |
      | Login    | Desktops      | camera                             |
      | Login    | Desktops      | Change thermal paste for processor |
      | Login    | Mobile Phones | Change thermal paste for processor |
      | Login    | Desktops      | camera                             |

  @asecuwe
  Scenario Outline:Navigate to <product> product from Featured Bar
    Given user is on "Home" page
    When user cliks on "<product>" product from Featured
    Then "<product>" product page is displayed
    Examples:
      | product            |
      | MacBook 123        |
      | iPhone             |
      | trtertretertertert |
      | fsdfffffffff       |


  Scenario Outline:Navigate to <product> product from Slide Bar
    Given user is on "Home" page
    When user cliks on "<product>" product from Slider
    Then "<product>" product page is displayed
    Examples:
      | product     |
      | iPhone 6    |
      | MacBook Air |

