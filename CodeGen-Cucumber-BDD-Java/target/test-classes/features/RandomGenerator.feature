@web @codeGen
Feature: Random Date Generator
  
  As a tester
  I want to genarate 10 random numbers
  So that I can see random numbers are generated
  
  
  Scenario: Generate random number

	Given I navigate to generate random date
	And I enter count as 10 in how many dates to generate
    When I select generate random dates
    Then I should see dates are generated