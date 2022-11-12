@Address
Feature: Address modulae API Automation

  Scenario Outline: Get address ID from Add address Endpoint
    Given User Should add Headers
    And User Should add request body for Adding Address using "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    When User Should send POST request for AddAddress endpoint
    Then User Should verify the status code 200
    And user Should verify the AddAddress response body message "Address added successfully" and the address_id should be saved

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address    | address_type |
      | Madhan     | Kumar     | 8050075265 | DABC      |    22 | 1211 |     100 |  090993 | HSR Layout | HOME         |

  Scenario Outline: Update User Address
    Given User Should add Headers
    And User Should pass payload to UpdateUserAddress "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    When User  Should send PUT request for UpdateUserAddress endpoint
    Then User Should verify the status code 200
    And User Should Verify the UpdateUserAddress response body message  "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address    | address_type |
      | kokila     | Madhan    | 8050075265 | DABC      |    22 | 1211 |     100 |  090993 | HSR Layout | WORK         |

  Scenario Outline: Delete UserAddress
    Given User Should add Headers
    And User passess payload to DeleteAddress
    When User send DELETE request for deleteAddress endpoint
    Then User Should verify the status code 200
    And User Should verify the deleteAddress response body message  "Address deleted successfully"

  Scenario Outline: Get UserAddress
    Given User Should add Headers
    And user send GET request for getAddress endpoint
    Then User Should verify the status code 200
    And User Should verify the getAddress response body message "OK"
