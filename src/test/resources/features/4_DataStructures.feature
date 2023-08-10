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
@DataStructures
Feature: User Validates the Data Structures module in DS Algo 
  
  @TC_DS_01
  Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When  The user enters valid username "Numpysdet117" and password "sdet117batch"
    And   The user clicks on login button
    Then  The user is redirected to the HomePage. 
    

  @TC_DS_02
  Scenario: The user is able to navigate to Data Structures introduction page
    Given The user is on the "NumpyNinja" after logged in
    When  The user clicks the "Get Started" button under Data Structures-Introduction
    Then  The user should be redirected to the "Data Structures-Introduction" page 
    
    
  @TC_DS_03
  Scenario: The user is able to navigate to Time Complexity page
    Given The user is on the "Data Structures-Introduction" after logged in
    When  The user clicks the Time Complexity link
    Then  The user should be redirected to the "Time Complexity" page
    
    
  @TC_DS_04
  Scenario: The user is able to navigate to a page having tryEditor from Time Complexity page
    Given The user is on the "Time Complexity" after logged in
    When  The user clicks "Try Here" button on "Time Complexity" page
    Then  The user should be redirected to the "Assessment" page
    
    
  @TC_DS_05
  Scenario Outline: The user is able to run code in tryEditor for Time Complexity page
    Given The user is in a page having an tryEditor with a Run button to test
    When  The user enters valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And   The user clicks on run button
    Then  The user should be presented with Run result
    
    Examples: 
      | Sheetname        | RowNumber |
      | PythonCode    |         0 |
      
    
    
    
  @TC_DS_06
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Time Complexity page
    Given The user is in a page having an tryEditor with a Run button to test
    When  The user enters python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And   The user clicks on run button
    Then  The user should be presented with error message
    
    Examples: 
      | Sheetname        | RowNumber |
      | PythonCode    |         1 |
      
    