Feature: add Product and Check Out www.saucedemo.com

  Scenario: Add Product to the cart
    Given I am logged in
    When I add a product to the cart
    Then I should see the product in the cart

  Scenario: Checkout Process
    Given I am logged in
    And I have products in the cart
    When I proceed to checkout
    And I enter shipping information
    And I complete the purchase
    Then I should see the order confirmation

