Feature: Web Server Testing

  Scenario: Retrieve logs from the server
    Given the web server is running
    When a GET request is made to "/logs"
    Then the response status code should be 200
    And the response format should be JSON
    And the response should contain logs

  Scenario: Create a new transaction
    Given the web server is running
    When a POST request is made to "/createLog"
    Then the response status code should be 200
    And the response format should be JSON
    And the response should contain a log entry