Feature: Create a New Quote
  As a sales representative
  I want to create a new quote for a customer
  So that I can provide them with pricing and product details quickly

  Background:
    Given the quote api service is running

  @AC_1
  Scenario Outline: : Successfully create a new quote with one item for a customer
    Given a customer "<customer_name>"
    And one item "<item_name>" with the quantity <quantity>, the unitary price <price>, and a percentage of <discount>
    When I create a quote for that customer with that items
    Then it returns the quote with the correct details, including the total line price calculated as <total_line_price>,
    And a confirmation message "Quote created successfully."
    Examples:
      | customer_name | item_name | quantity | price | discount | total_line_price |
      | Noushin       | Product A | 2        | 10.00 | 0.0      | 20.00            |
      | Noushin       | Product B | 3        | 15.00 | 0.0      | 45.00            |

  @AC_2
  Scenario Outline: Successfully create a new quote with one item with discount for a customer
    Given a customer "<customer_name>"
    And one item "<item_name>" with the quantity <quantity>, the unitary price <price>, and a percentage of <discount>
    When I create a quote for that customer with that items
    Then it returns the quote with the correct details, including the discount amount <discount_amount> and the total lineprice <total_line_price>
    And a confirmation message "Quote created successfully."
    Examples:
      | customer_name | item_name | quantity | price | discount | discount_amount | total_line_price |
      | Noushin       | Product B | 3        | 15.00 | 0.05     | 2.25            | 42.75            |
      | Noushin       | Product C | 2        | 50.00 | 0.1      | 10.00           | 90.00            |


  @AC_3
  Scenario Outline: Successfully create a new quote with two items for a customer
    Given a customer "<customer_name>"
    And one item "<item_A>" with the quantity <quantity_A>, the unitary price <price_A>, and a percentage of 0
    And one item "<item_B>" with the quantity <quantity_B>, the unitary price <price_B>, and a percentage of 0
    When I create a quote for that customer with that items
    Then the response status code is 200
    Then it returns the quote with the correct details, including two lines and the total quote price calculated as <total_quote_price>
    And a confirmation message "Quote created successfully."
    Examples:
      | customer_name | item_A    | quantity_A | price_A | item_B    | quantity_B | price_B | total_quote_price |
      | Noushin       | Product A | 2          | 30.00   | Product B | 3          | 20.00   | 120.00            |
      | Noushin       | Product X | 5          | 10.00   | Product Y | 1          | 100.00  | 150.00            |


  @AC_4
  Scenario Outline: Successfully create a new quote with two items with discount for a customer
    Given a customer "<customer_name>"
    And one item "<item_A>" with the quantity <quantity_A>, the unitary price <price_A>, and a percentage of <discount_A>
    And one item "<item_B>" with the quantity <quantity_B>, the unitary price <price_B>, and a percentage of <discount_B>
    When I create a quote for that customer with that items
    Then it returns the quote with the correct details, including two lines and the total quote price calculated as <total_quote_price>
    And a confirmation message "Quote created successfully."

    Examples:
      | customer_name | item_A    | quantity_A | price_A | discount_A | item_B    | quantity_B | price_B | discount_B | total_quote_price |
      | Noushin       | Product A | 2          | 100     | 0.1        | Product B | 3          | 20.00   | 0.5        | 210.00            |


   # Negative

  @AC_5
  Scenario Outline: Create a quote with missing customer name
    Given a customer ""
    And one item "<item_name>" with the quantity <quantity>, the unitary price <price>, and a percentage of 0
    When I create a quote for that customer with that items
    Then the response status code is 400
    And the error message "Customer or Items cannot be null or empty"

    Examples:
      | item_name | quantity | price |
      | Product A | 2        | 10.00 |

  @AC_6
  Scenario Outline: Create a quote with invalid quantity
    Given a customer "<customer_name>"
    And one item "<item_name>" with the quantity <quantity>, the unitary price <price>, and a percentage of 0
    When I create a quote for that customer with that items
    Then the response status code is 400
    Examples:
      | customer_name | item_name | quantity | price |
      | Noushin       | Product B | -100     | 15.00 |
      | Noushin       | Product C | -5       | 10.00 |

  @AC_7
  Scenario Outline: Create a quote with invalid price
    Given a customer "<customer_name>"
    And one item "<item_name>" with the quantity <quantity>, the unitary price <price>, and a percentage of 0
    When I create a quote for that customer with that items
    Then the response status code is 400
    Examples:
      | customer_name | item_name | quantity | price  |
      | Noushin       | Product C | 2        | -10.00 |
      | Noushin       | Product D | 3        | -5.00  |

  @AC_8
  Scenario Outline: Create a quote with zero price
    Given a customer "<customer_name>"
    And one item "<item_name>" with the quantity <quantity>, the unitary price 0, and a percentage of 0
    When I create a quote for that customer with that items
    Then the response status code is 400
    Examples:
      | customer_name | item_name | quantity |
      | Noushin       | Product C | 2        |
      | Noushin       | Product D | 3        |

#Edge case
  @AC_9
  Scenario Outline: Create a quote with discount exceeding 100%:
    Given a customer "<customer_name>"
    And one item "<item_name>" with the quantity <quantity>, the unitary price <price>, and a percentage of <discount>
    When I create a quote for that customer with that items
    Then the response status code is 400
    Examples:
      | customer_name | item_name | quantity | price | discount |
      | Noushin       | Product B | 3        | 15.00 | 1.1      |