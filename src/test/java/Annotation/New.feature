Feature: New 

Background: User navigates to localhost 
	Given I am on list page 
	
Scenario Outline: 
	When I click on add employee 
	And I enter employee name as <name> 
	And I enter date as <date> 
	And I enter employee salary as <salary> 
	And I enter employee ssn as <ssn> 
	Then Registration should <status> 
	
	Examples: 
		| name | date | salary | ssn | status |
		| "Jerome" | "02-02-2017" | "5000" | "1122334" | succeed |
		| "Jerome" | "02-02-2017" | "5000" | "1122334" | fail |
		| "Jerome" | "123-02-2017" | "5000" | "11223344" | fail |
		| "Jerome" | "02-13-2017" | "5000" | "11223344" | fail |		
		| "a" | "02-02-2017" | "5000" | "11223344" | fail |
		| "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" | "02-02-2017" | "5000" | "11223344" | fail |
		| "!@#$%^&*" | "02-02-2017" | "5000" | "11223344" | fail |
		| "Jerome" | "02-02-2017" | "abcde" | "112233444" | fail |
		| "Jerome" | "02-02-2017" | "!@#$%^&*" | "1122334444" | fail |
		| "Jerome" | "02-02-2017" | "5000.659826" | "11223344444" | fail |
		| "Jerome" | "02-02-2017" | "5000" | "!@#%^&*(" | fail |
	