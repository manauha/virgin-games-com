@HU @Regression
Feature: Test Cases 1, 2 and 3

  As an User I want to check
  Test Case 1 Navigate to the homePage successfully
  Test case 2 Verify top menu functionality
  Test Case 3 Navigate to the Modern Slavery Act Page

  Background: User is on the homepage and click on Allow all cookies
    Given I launch the browser
    When I navigate to given url
    Then I click on Allow All cookies

  @Smoke
  Scenario: Test Case 1 Navigate to the homePage successfully
    Then I verify that home page is visible successfully
    And I verify "Welcome to Virgin Games" is visible


  @Sanity
  Scenario Outline: Test case 2 Verify the top menu functionality
    When I am on the homepage
    And I click on the "<Tab>" on TopMenu
    Then I navigated to the clicked "<TabPage>" successfully

    Examples:
      | Tab          | TabPage                                      |
      | Online Slot  | https://www.virgingames.com/uk/slots         |
      | Live Casino  | https://www.virgingames.com/uk/live-casino   |
      | Casio        | https://www.virgingames.com/uk/online-casino |
      | Slingo       | https://www.virgingames.com/uk/slingo        |
      | Online Bingo | https://www.virgingames.com/uk/online-bingo  |
      | Free Games   | https://www.virgingames.com/uk/free-games    |
      | Poker        | https://www.virgingames.com/uk/online-poker  |
      | All Games    | https://www.virgingames.com/uk/all-games     |
      | Blog         | https://www.virgingames.com/uk/blog          |


  @Regression
  Scenario: Test Case 3 Navigate to the Modern Slavery Act Page
    When I am on the homepage
    And I go down to legal lines
    Then I click on Modern Slavery Statement
    And I navigate to "MODERN SLAVERY ACT TRANSPARENCY STATEMENT" Page Successfully
    And I verify page URL