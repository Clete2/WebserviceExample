Feature: Job Repository
	Test the Job Repository's features.
	
	Background:
		Given there is a Job that pays between 80000 and 100000 called Burger Flipper
		When I search for a Job with a title of Burger Flipper
	
	Scenario: Search for a Job by title
		Then the Jobs should be the same
	
	Scenario: Job Minimum Pay
		Then the Job should pay at least 80000
	
	Scenario: Job Maximum Pay
		Then the Job should pay at most 100000
		
	Scenario: Job Title
		Then the Job title should be Burger Flipper