#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SignIn
Feature: User Validates the Signin page in DS Algo
 
   @TC_Signin_01
  Scenario: Verify the register link
    Given The user opens Signin page
    When The user clicks on Register link on signin page
    Then The user redirected to Registration page from signin page
    
    @TC_Signin_02
  Scenario: The user is able to navigate to Signin Page from Register Page
    Given The user is on Register page
    When The user clicks on Sign in link on Register Page
    Then The user is redirected to the Sign in page
    
    @TC_Signin_03
  Scenario Outline: User on login page and login with invalid and valid inputs from Excel "<Sheetname>" and <RowNumber>
    Given The user is on Sign in page
    When The user enter sheet "<Sheetname>" and <RowNumber>
    Then click login button

    Examples: 
      | Sheetname | RowNumber |
      | SignIn    |         0 |
      | SignIn    |         1 |
      | SignIn    |         2 |
      | SignIn    |         3 |
      | SignIn    |         4 |
      | SignIn    |         5 |
      
      
      @TC_Signin_04
  Scenario: Verifying signout link
    Given The user is on signin page with valid username "Numpysdet117" and password "sdet117batch"
    When The user click signout button
    Then The user redirected to homepage
      