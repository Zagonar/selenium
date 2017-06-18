Feature: acceptanceTest

  Scenario: check whether the sum of items in the bag is correct
    Given I navigate to "https://www.yoox.com/it/uomo"
    And I go to item selection's page
    When I add two random prioducts to the bag
    And I navigate to the bag
    And I add one more instance of a product
    Then The final price must be correct