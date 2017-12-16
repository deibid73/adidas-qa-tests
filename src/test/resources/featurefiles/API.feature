@API @RUNNABLE
Feature: Adidas API tests
  As a candidate I want to test Adidas API so I can pass the challenge

  Background: get the main API response into an object
    Given I get the API response under 1 sec


  @TC01
  Scenario: every component	has	at least analytics  data “analytics_name” in it
    When I get all the components list
    Then all the components have analytics_name in them
  @TC02
  Scenario: every image is loadable
    When I get all the components list
    Then all the images load
