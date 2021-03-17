Feature: Invoice

  Scenario: Invoice with known properties
    When An invoice is generated with following values
      | Total | Sales Tax 10% | Sales Tax 50% | Environmental Deposit |
      | 12.00 | 2.30          | 0.70          | 6.00                  |
    Then The invoice total is 12.00
    And The sales tax 10% is 2.30
    And The sales tax 50% is 0.70
    And The environmental deposit is 6.00

  Scenario: Two invoices must be different
    When Two invoices are generated with the following values
      | Total | Sales Tax 10% | Sales Tax 50% | Environmental Deposit |
      | 12.00 | 2.30          | 0.70          | 6.00                  |
      | 12.00 | 2.30          | 0.70          | 6.00                  |
    Then The invoices must be unequal

