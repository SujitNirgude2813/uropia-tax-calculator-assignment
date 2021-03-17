Feature: Billing Service

  Scenario: Cart billing total for empty cart
    Given An empty cart
    When The bill is generated
    Then The invoice total should be 0.00

