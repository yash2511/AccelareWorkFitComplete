Feature: Capability(Model) module feature

Scenario: User is Logged In
	Given Accelare url is launched
	When User Enters valid username "yashodeep.patil@nitorinfotech.com" and password "Workfit2511#"
	Then Verify if App Testing Accelare is opened
	And Click on verify app testing page
  

Scenario: Create a new model
	Given user navigated to new model form
	When User click on new model link
	Then User is able to see the model in dropdown model
  And Click on verify app testing page
  

Scenario: Import the model
	Given User navigate to the model import window
	When user click on design button
	Then user is able to upload the model
	And Click on verify app testing page

Scenario: Export the model	
	Given User navigate to the model export window
	When user click on Export button
	Then user is able to export the model
	And Click on verify app testing page
	

Scenario: Add Process Family
		Given user will add the process family		
		When user click on add process family
		Then user is able to add process family
		And Close the browser
	

	
		