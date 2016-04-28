Feature: Job Repository
	Test the Job Repository's features.
	
	Background:
		Given there is a Job that pays between 80000 and 100000 called Burger Flipper
		When I search for a Job with a title of Burger Flipper
	
	Scenario: Search by title
		Then the Jobs should be the same
	
	Scenario: Minimum Pay
		Then the Job should pay at least 80000
	
	Scenario: Maximum Pay
		Then the Job should pay at most 100000
		
	Scenario: Title
		Then the Job title should be Burger Flipper
		
	Scenario: Delete
		Then delete the Job
		Then the Job should be deleted
		
	Scenario: Change Title
		Then change the title of the Job to Money Printer
		Then the Job title should be Money Printer
	
	Scenario: Change Minimum Pay
		Then change the minimum pay of the Job to 10
		Then the Job should pay at least 10
		
	Scenario: Change Maximum Pay
		Then change the maximum pay of the Job to 100
		Then the Job should pay at most 100