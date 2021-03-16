Feature: Item

  Scenario: Item with known properties
    When An item is created with name as "Book", quantity as 1, unit price as 15.54
    Then The name of Item should be "Book"
