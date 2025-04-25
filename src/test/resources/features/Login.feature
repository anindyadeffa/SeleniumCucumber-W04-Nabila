Feature: Login and Add To Cart

  # TCC.SD.001
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    Then I should be redirected to inventory page
    And Adds one product to the cart

  # TCC.SD.002
  Scenario: Invalid login with invalid credentials
    Given I am on the login page
    When I enter a invalid username and password
    And I click the login button
    Then I see message invalid credentials