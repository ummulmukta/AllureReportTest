
Feature: login functionality test
Scenario: positive
Given I am on facebook page
When I enter user name
And I enter password
And I click login
Then I successfully logged in