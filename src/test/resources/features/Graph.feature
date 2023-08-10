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
@Graph
Feature: User Validates the Graph module in DS Algo 
  
  @TC_Graph_01
  Scenario: The user redirected to homepage

    Given The user is on Signin page of DS Algo portal
    When The user enters valid username "Numpysdet117" and password "sdet117batch"
    And The user clicks on login button
    Then The user redirected to homepage

  @TC_Graph_02
  Scenario: User navigated to Graph page

    Given The user is on the "NumpyNinja" after logged in
    When The user select Graph item from the drop down menu
    Then The user should be redirected to the "Graph" page 
    
   @TC_Graph_03
  Scenario: The user is able to navigate to "Graph" page


    Given The user is on the Graph page after logged in
    When The user clicks on the Graph link
    Then The user should then be directed to Graph Page
    
    
 @TC_Graph_04
  Scenario: The user is able to navigate to a page having an tryEditor


    Given The user is on the "Graph" after logged in
    When The user clicks "Try Here" button on "Graph" page
    Then The user should be redirected to the "Assessment" page


  @TC_Graph_05
    Scenario Outline:  The user run the code in tryEditor with the valid input  

    Given The user is in a page having an tryEditor with a Run button to test
    When  The user enters valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And   The user clicks on run button
    Then  The user should be presented with Run result
    
    Examples: 
      | Sheetname        | RowNumber |
      |  PythonCode      |        24 |
      
      
  @TC_Graph_06
    Scenario Outline: The user is presented with error message for code with the invalid syntax in tryEditor 
     
    Given The user is in a page having an tryEditor with a Run button to test
    When  The user enters python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And   The user clicks on run button
    Then  The user should be presented with error message
    
    Examples: 
      | Sheetname        | RowNumber |
      |  PythonCode      |        25 |
      
     
   @TC_Graph_07
    Scenario: User navigated to Graph page
    
    Given The user is on the try editor after validating the python code
    When The user clicks back to the previous page from try editor
    Then The user should be redirected to the "Graph" page
      
   @TC_Graph_08
     Scenario:  User navigated to Graph Representations page

    Given The user is on the Graph page
    When The user clicks the Graph Representations link
    Then The user should be redirected to the "Graph Representations" page
    
    
    @TC_Graph_09
  Scenario: The user is able to navigate to a page having an tryEditor


    Given The user is on the "Graph Representations" after logged in
    When The user clicks "Try Here" button on "Graph Representations" page
    Then The user should be redirected to the "Assessment" page


  @TC_Graph_10
    Scenario Outline:  The user run the code in tryEditor with the valid input  

    Given The user is in a page having an tryEditor with a Run button to test
    When  The user enters valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And   The user clicks on run button
    Then  The user should be presented with Run result
    
    Examples: 
      | Sheetname        | RowNumber |
      |  PythonCode      |        26 |
      
      
  @TC_Graph_11
    Scenario Outline: The user is presented with error message for code with the invalid syntax in tryEditor 
     
    Given The user is in a page having an tryEditor with a Run button to test
    When  The user enters python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And   The user clicks on run button
    Then  The user should be presented with error message
    
    Examples: 
      | Sheetname        | RowNumber |
      |  PythonCode      |        25 |
      
      
    @TC_Graph_12
    Scenario: User navigated to Graph Representations page
    
    Given The user is on the try editor after validating the python code
    When The user clicks back to the previous page from try editor
    Then The user should be redirected to the "Graph Representations" page
    
    @TC_Graph_13
     Scenario:  User navigated to Practice Questions page

    Given The user is on the Graph Representations page
    When The user clicks the Practice Questions link
    Then The user should be redirected to the "Practice Questions" page
     
      