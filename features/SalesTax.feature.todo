Feature: Sales Tax

  Scenario: Empty Shopping Cart
    An empty shopping cart has no taxes.
    Given the shopping cart contains the following items:
      | Item | Count | Price |
    When generating the bill
    Then the "total" MUST be 0.00
    And the "sales tax 10%" MUST be 0.00
    And the "sales tax 50%" MUST be 0.00
    And the "import tax" MUST be 0.00

  Scenario: Shopping Cart with one book
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item | Count | Price |
      | Book | 1     | 12.49 |
    When generating the bill
    Then the "total" MUST be 12.49
    And the "sales tax 10%" MUST be 0.00
    And the "sales tax 50%" MUST be 0.00
    And the "import tax" MUST be 0.00
