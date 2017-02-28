Feature: Welcome 
#This is how background can be used to eliminate duplicate steps 

Background: 
	User navigates to Facebook 
	Given I am on welcome page 
	
	#Scenario with AND 
Scenario: 
	When I click on login link 
	Then I shoule be on login page