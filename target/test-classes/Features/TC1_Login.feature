@Login
Feature: Login modulae API Automation

  Scenario Outline: User get logtoken from Login Endpoint
    Given User Should add Header
    And User Should add basic Authentication for login
    When User Should send POST request for login EndPoint
    Then User Should verify the status code 200
    And User Should verify the login response body first name is "MathanKumar" and  the logtoken Should be saved
