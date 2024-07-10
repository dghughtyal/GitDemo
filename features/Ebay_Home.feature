Feature: Ebay Home Page Scenarios

  @P1 @P0
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @P11 @setCookies @tesT
  Scenario: Search items count
    Given I am on Ebay Home Page
    When I search for 'iPhone 11'
    Then I validate atleast 1000 search items present

  @P12 @setCookies
  Scenario: Search an item in category
    Given I am on Ebay Home Page
    When I search for 'soap' in 'Baby' category
    Then I validate atleast 50 search items present

  @P13
  Scenario Outline: Home page category links
    Given I am on Ebay Home Page
    When I click on the '<link>'
    Then I validate that the page navigates to '<url>' and title contains '<title>'

    Examples: 
      | link    | url                                                                | title    |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | Motors   |
      | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497                 | Toys     |
