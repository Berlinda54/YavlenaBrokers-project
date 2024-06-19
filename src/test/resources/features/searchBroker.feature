Feature: Broker Search Functionality

Scenario: Search for a broker by name and verify details
Given user is on the broker search page
When user gets the name of a broker
And searches that name of the broker
Then the searched broker should be the only one displayed
And user should see brokers address, phone numbers and number of properties