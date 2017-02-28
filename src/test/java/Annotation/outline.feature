Feature: Login 
#This is how background can be used to eliminate duplicate steps 

Background: User navigates to localhost 
	Given I am on login page 
	
Scenario Outline: Incorrect username and password
	When I enter username as <username> 
	And I enter password as <password> 
	Then Login should fail 
	Examples: Username and password table
		| username | password  | 
		| "user1"    | "password1" | 
		| "user2"    | "password2" |
		
		
