@UI @RUNNABLE
Feature: UI-Tests For the adidas homepage
  As a candidate I want to test the adidas homepage so that I pass the technical challenge

  Background: Prepare driver and open page
    Given I open the adidas home page


  @TC01
  Scenario Outline: Top level menu items tests, verify that the top level menu items navigate to correct sub portals
    Given I select the <locale> locale
    When I select the <link> link
    Then the <page> home page is loaded

    Examples:
      | locale |  | link      |  | page      |
      | fi_FI  |  | Men       |  | men       |
      | fi_FI  |  | Women     |  | women     |
      | fi_FI  |  | Kids      |  | kids      |
      | fi_FI  |  | Customise |  | customise |
      | en_GB  |  | Men       |  | men       |
      | en_GB  |  | Women     |  | women     |
      | en_GB  |  | Kids      |  | kids      |
      | en_GB  |  | Customise |  | customise |