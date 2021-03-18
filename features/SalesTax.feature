Feature: Sales Tax

  Scenario: Empty Shopping Cart
  An empty shopping cart has no taxes.
    Given the shopping cart contains the following items:
      | Item | Count | Price |
    When generating the bill
    Then the "total" MUST be 0.00
    And the "sales tax 10%" MUST be 0.00
    And the "sales tax 50%" MUST be 0.00
    And the "environmental deposit" MUST be 0.00

  Scenario: Shopping Cart with one book
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item | Count | Price |
      | Book | 1     | 12.49 |
    When generating the bill
    Then the "total" MUST be 12.49
    And the "sales tax 10%" MUST be 0.00
    And the "sales tax 50%" MUST be 0.00
    And the "environmental deposit" MUST be 0.00

  Scenario: Shopping Cart with one book and one chocolate
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item      | Count | Price |
      | Book      | 1     | 12.50 |
      | Chocolate | 1     | 2.25  |
    When generating the bill
    Then the "total" MUST be 14.75
    And the "sales tax 10%" MUST be 0.00
    And the "sales tax 50%" MUST be 1.13
    And the "environmental deposit" MUST be 0.00

  Scenario: Shopping Cart with one book, one chocolate and wooden chair
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item         | Count | Price |
      | Book         | 1     | 12.50 |
      | Chocolate    | 2     | 2.25  |
      | Wooden Chair | 1     | 30.00 |
    When generating the bill
    Then the "total" MUST be 47.00
    And the "sales tax 10%" MUST be 3.00
    And the "sales tax 50%" MUST be 2.25
    And the "environmental deposit" MUST be 0.00

  Scenario: Shopping Cart with items for items having deposit
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item         | Count | Price  |
      | Book         | 1     | 12.50  |
      | Chocolate    | 2     | 2.25   |
      | Wooden Chair | 1     | 30.00  |
      | Mobile Phone | 1     | 130.00 |
      | Coke         | 5     | 1.49   |
    When generating the bill
    Then the "total" MUST be 184.45
    And the "sales tax 10%" MUST be 3.00
    And the "sales tax 50%" MUST be 2.25
    And the "environmental deposit" MUST be 54.50

  Scenario: Shopping Cart with duplicate items
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item         | Count | Price |
      | Book         | 1     | 12.50 |
      | Chocolate    | 2     | 2.25  |
      | Wooden Chair | 1     | 30.00 |
      | Coke         | 5     | 1.49  |
      | Chocolate    | 2     | 2.25  |
    When generating the bill
    Then the "total" MUST be 58.95
    And the "sales tax 10%" MUST be 3.00
    And the "sales tax 50%" MUST be 4.50
    And the "environmental deposit" MUST be 2.50

  Scenario: Shopping Cart with two oil cans
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item    | Count | Price |
      | Oil Can | 2     | 23.35 |
    When generating the bill
    Then the "total" MUST be 46.70
    And the "sales tax 10%" MUST be 4.67
    And the "sales tax 50%" MUST be 0.00
    And the "environmental deposit" MUST be 1.00

  Scenario: Shopping Cart with two oil cans
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item      | Count | Price    |
      | Tesla Car | 1     | 40000.00 |
    When generating the bill
    Then the "total" MUST be 40000.00
    And the "sales tax 10%" MUST be 0.00
    And the "sales tax 50%" MUST be 20000.00
    And the "environmental deposit" MUST be 16000.00

  Scenario: Shopping Cart with all categories of items
  A shopping cart with a book has no taxes because books are tax-exempt.
    Given the shopping cart contains the following items:
      | Item         | Count | Price    |
      | Tesla Car    | 1     | 40000.00 |
      | Book         | 1     | 12.50    |
      | Chocolate    | 2     | 2.25     |
      | Wooden Chair | 1     | 30.00    |
      | Coke         | 5     | 1.49     |
      | Oil Can      | 2     | 23.35    |
      | Chocolate    | 2     | 2.25     |
    When generating the bill
    Then the "total" MUST be 40105.65
    And the "sales tax 10%" MUST be 7.67
    And the "sales tax 50%" MUST be 20004.50
    And the "environmental deposit" MUST be 16003.50
