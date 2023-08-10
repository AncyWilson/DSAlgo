package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataStructures;
import pageObjects.SignInPage;
import utilities.ConfigReader;
import utilities.ElementsUtils;
import utilities.LoggerLoad;

public class DataStructuresSD {
	
	SignInPage signin = new SignInPage();
	String excelfilepath = ConfigReader.getExcelFilePath();
	DataStructures data = new DataStructures();
    ElementsUtils elementUtil = new ElementsUtils();
	static String code;
	static String result;
	static String expectedResult;
	
	
	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		signin.getLoginPage();
		//signin.navigateToSignInLink();
	}

	@When("The user enters valid username {string} and password {string}")
	public void the_user_enters_valid_username_and_password(String string, String string2) {
	    signin.doLogin(string, string2);
	}

	@When("The user clicks on login button")
	public void the_user_clicks_on_login_button() {
	    signin.loginButton();
	}

	@Then("The user is redirected to the HomePage.")
	public void the_user_is_redirected_to_the_home_page() {
		String Title = signin.verifyPageTitle();
		LoggerLoad.info("Title of current page is" + Title);
		assertEquals(Title, "NumpyNinja", "Pass : Titles match");
	}

	@Given("The user is on the {string} after logged in")
	public void the_user_is_on_the_after_logged_in(String pageName) {
		String Title = data.verifyPageTitle();
		LoggerLoad.info("Title of current page is " + Title);
		assertEquals(Title, pageName, "Title do not match");
	}
	    
	

	@When("The user clicks the {string} button under Data Structures-Introduction")
	public void the_user_clicks_the_button_under_data_structures_introduction(String string) {
	    data.getStarted(string);
	}

	@Then("The user should be redirected to the {string} page")
	public void the_user_should_be_redirected_to_the_page(String pageName) {
		String Title = data.verifyPageTitle();
		LoggerLoad.info("Title of current page is" + Title);
		assertEquals(Title, pageName, "Pass : Titles match"); 
	}	

	@When("The user clicks the Time Complexity link")
	public void the_user_clicks_the_time_complexity_link() {
	    data.timeCom();
	}
	
	@When("The user clicks {string} button on {string} page")
	public void the_user_clicks_button_on_page(String string, String string2) {
	    data.tryHere();
	}

	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
		String Title = data.verifyPageTitle();
		LoggerLoad.info("Title of current page is" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	    
	}

	@When("The user enters valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enters_valid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer rowNumber) throws Exception {
		LoggerLoad.info("User enters valid python code in tryEditor from sheetname :" + sheetName + " and row number : " + rowNumber);
		data.enterPythonCode(sheetName, rowNumber);
		expectedResult = data.getExpectedResult(sheetName, rowNumber);
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
		LoggerLoad.info("User clicks on run button");
		data.run();
		
	    
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		LoggerLoad.info("User should be presented with run result ");
		LoggerLoad.info("Expected result : " + expectedResult);
		String actualMsg = data.getActualResult();
		LoggerLoad.info("Actual result : " + actualMsg);
		  assertEquals(actualMsg , expectedResult, "Result do not match");
	    
	}

	@When("The user enters python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enters_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String sheetName, Integer rowNumber) throws Exception {
		LoggerLoad.info("User enters invalid python code in tryEditor from sheetname :" + sheetName + " and row number : " + rowNumber);
		
		data.enterPythonCode(sheetName, rowNumber);
		expectedResult = data.getExpectedResult(sheetName, rowNumber);
	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
		LoggerLoad.info("User should be presented with error message");
		LoggerLoad.info("Expected result : " + expectedResult);
	  String actualErrorMsg = data.getAlertErrorText();
	  LoggerLoad.info("Actual Error Message : " + actualErrorMsg);
	  assertEquals(actualErrorMsg, expectedResult, "Result do not match");
		}
	    
	}



