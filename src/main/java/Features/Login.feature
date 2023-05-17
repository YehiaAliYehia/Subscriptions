Feature: Validating Subscriptions Type & Price and Currency for all Countries (SA / Kuwait and Baharin)


  Background: Navigate to Subscriptions link
    Given Navigate to the link

Scenario: Validate the type of Subscription for Saudi country
  When the user selects the Saudi country
  Then Subscription Plans should be displayed
  Then Saudi Subscriptions Should have types

  Scenario: Validate the type of Subscription for Bahrain country
    When the user selects the Bahrain country
    Then Subscription Plans should be displayed
    Then Bahrain Subscriptions Should have types


  Scenario: Validate the type of Subscription for Kuwait country
    When the user selects the Kuwait country
    Then Subscription Plans should be displayed
    Then Kuwait Subscriptions Should have types


  Scenario: Validate the Prices of Subscription for Saudi  country
    When the user selects the Saudi  country
    Then Subscription Plans should be displayed
    Then Every Subscription Should have price In Saudi

  Scenario: Validate the Prices of Subscription for Bahrain country
    When the user selects the Bahrain country
    Then Subscription Plans should be displayed
    Then Every Subscription Should have price In Bahrain Country

  Scenario: Validate the Prices of Subscription for Kuwait country
    When the user selects the Kuwait country
    Then Subscription Plans should be displayed
    Then Every Subscription Should have price IN KW

  Scenario: Validate the Currency of Subscription for Saudi country
    When the user selects the Saudi country
    Then Subscription Plans should be displayed
    Then  Currency Should be SAR

  Scenario: Validate the Currency of Subscription for Bahrain country
    When the user selects the Bahrain country
    Then Subscription Plans should be displayed
    Then  Currency of Bahrain Should be BH

  Scenario: Validate the Currency of Subscription for Kuwait country
    When the user selects the Kuwait country
    Then Subscription Plans should be displayed
    Then  Currency Should be KW



