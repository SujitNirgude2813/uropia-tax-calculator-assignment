Feature: Billing Service

  Scenario: Cart billing total for empty cart
    Given An empty cart
    When The bill is generated
    Then The invoice total should be 0.00
    And The sales tax 10% should be 0.00
    And The sales tax 50% should be 0.00
    And The environmental deposit should be 0.00
