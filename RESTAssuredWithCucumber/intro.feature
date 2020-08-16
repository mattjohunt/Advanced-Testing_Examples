Feature: Testing OMDB API

  Scenario: Testing a status code
    Given a JSON request
    When a user retrieves the film by the title Guardians of the Galaxy Two
    Then the status code reads 200

  Scenario: Testing both a status code and a field
    Given a JSON request
    When a user retrieves the film by the title IT
    Then the status code reads 200
    And the Rated Field is equal to R

  Scenario: Testing the API using parameters
    Given a JSON request
    When a user retrieves the film by the title "Hop"
    Then the status code reads 200
    And the Rated Field is equal to "PG"

  Scenario Outline: Testing the API using a table
    Given a JSON request
    When a user retrieves the film by the title "<title>"
    Then the status code reads 200
    And the Rated Field is equal to "<rating>"

    Examples: 
      | title | rating |
      | Hop   | PG     |
      | IT    | R      |
      | Up    | PG     |
      | Saw   | R      |
