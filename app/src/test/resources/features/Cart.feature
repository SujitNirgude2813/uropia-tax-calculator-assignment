Feature:

  Scenario: Empty shopping cart
    An empty shopping cart has no item
    Given An empty shopping cart
    Then The item count of cart must be 0

  Scenario: Cart with one item
    Create a cart having one item
    Given A cart with following items
      | Item | Count | Price |
      | Book | 1     | 12.49 |
    Then The item count of cart must be 1

  Scenario: Cart with many items
    Given A cart with following items
      | Item | Count | Price |
      | Book | 1     | 12.49 |
      | Toys | 2     | 13.09 |
    Then The item count of cart must be 2

  Scenario: Duplicate Item is added to cart
    Given A cart with following items
      | Item | Count | Price |
      | Book | 2     | 12.49 |
    When Item with name as "Book", count as 1 and Price as 12.49 is added to cart
    Then The item count of cart must be 1
    And The quantity of this item should be 3
