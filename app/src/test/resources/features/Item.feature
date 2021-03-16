Feature: Item

  Scenario: Item with known properties
    When An item is created with name as "Book", quantity as 1, unit price as 15.54
    Then The name of Item should be "Book"
    And The count of Item should be 1
    And The price of Item should be 15.54

  Scenario: Two items with known properties
    Given Two item with name, quantity and price are as follows:
      | Item | Count | Price |
      | Book | 1     | 12.49 |
      | Book | 2     | 12.49 |
    Then Both items should be equal

    Given Two item with name, quantity and price are as follows:
      | Item | Count | Price |
      | Toy  | 3     | 2.49  |
      | Book | 1     | 12.49 |
    Then Both items should not be equal

