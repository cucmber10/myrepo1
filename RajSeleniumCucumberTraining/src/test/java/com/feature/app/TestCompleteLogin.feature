@tag
Feature: TestComplete Login page
@tag1
  Scenario: TestComplete Login page Sencarios
    Given I go to "qaurl" and with "chrome"
    When I enter "Tester" in the "usertxtbox_id"
    And I enter "test" in the "password_id"
    And I click on "login_id" button
    Then I validate "viewallorders_linktext" the Logged successful
    And I click on "Viewallproducts_linktext" button
    Then I verified "listofproducts_linktext" text is displayed
    And I click on "order_linktext" button
    Then I verified "order_cssSelector" text is displayed
    
