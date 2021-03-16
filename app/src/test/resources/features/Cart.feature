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


