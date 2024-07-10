Feature: Ebay Advanced Search Page

  @P2
  Scenario: Ebay Logo on Advanced Search Page
    Given I am on Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I am navigated to Ebay Home Page

  @P21 @setCookies
  Scenario: Advance Search on an item
    Given I am on Ebay Advanced Search Page
    When I Advance Search an item
      | Keyword   | Exclude     | Min price | Max price |
      | iPhone 11 | refurbished |       300 |       900 |
