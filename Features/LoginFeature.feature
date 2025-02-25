Feature: Login

Scenario: successful Login with Valid Credentials
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	#Then Page Title should be "Dashboard / nopCommerce administration"
	#When User click on Log out link
	#Then Page Title should be "Your store.Login"
	And close browser
	
Scenario Outline: Successfull login with Valid Credentials DDT	
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as <"email"> and Password as <"password">
	And Click on Login

Examples:
|email|password|
|admin@yourstore.com|admin|
|test@yourstore.com|admin|