
Feature: IBE booking flow

  Background:
    Given Validate the browser
    When Browser is triggered
    Then Check if the URL is correct

  @SmokeTest
  Scenario: Create booking of 2 ADT 1 CHD through IBE with incorrect credit card
    Given I make a booking from origin to destination on 22/02/2023 for 2 adults and 1 child
    |Berlin|Lahiru|Vikasitha|Disna|Kumari|Mihidi|Yeleena|
    When I pay for booking with card details card number, expiry date and cvv
    |123456789258|5555 5555 5555 5557|1025|265|Lahiru Vikasitha|No 45 / 1|Muwanpalassa|Sooriyawewa|Sri Lanka, Democratic Socialist Republic of (was Ceylon)|82010|
    Then I should get payment declined message


