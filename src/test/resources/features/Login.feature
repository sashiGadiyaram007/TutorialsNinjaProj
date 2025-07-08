Feature: Login Functionality

Scenario: Login with Valid Credentails
Given User has navigates to login page
When User enters valid email address "rohini.123@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on login button
Then User should get successfully logged in

Scenario: Login with Invalid Credentials
Given User has navigates to login page
When User enters invalid email address "rohini.1234567890@gmail.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigates to login page
When User enters valid email address "rohini.123@gmail.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid Password
Given User has navigates to login page
When User enters invalid email address "rohini.1234567890@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any details
Given User has navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch 
