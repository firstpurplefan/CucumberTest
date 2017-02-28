Feature: Delete 
#This is how background can be used to eliminate duplicate steps 

Background: 
	User navigates to Facebook 
	Given I am on list page
	
Scenario:
	When I click on add employee
	And I enter employee name as "Jerome"
	And I enter date as "01-02-2017"
	And I enter employee salary as "5000"
	And I enter employee ssn as "BSB22335"
	Then Registration should succeed

Scenario: 
	When I open employee page as "BSB22335"
	And I click on delete button
	And I confirm the delete
	Then Delete should succeed
	
Scenario:
	When I click on add employee
	And I enter employee name as "Jerome"
	And I enter date as "01-02-2017"
	And I enter employee salary as "5000"
	And I enter employee ssn as "BSB22335"
	Then Registration should succeed
	
Scenario: 
	When I open employee page as "BSB22335"
	And I click on delete button
	And I cancel the delete
	Then Delete should fail