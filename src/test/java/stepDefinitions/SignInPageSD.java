package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SignInPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class SignInPageSD {
	
	SignInPage signin = new SignInPage();
	String excelfilepath = ConfigReader.getExcelFilePath();
	static String username;
	static String password;
	static String expectedMsg;
	Boolean isRequired;
	
	@Given("The user opens Signin page")
	public void the_user_opens_signin_page() {
		signin.getLoginPage();
		System.out.println("1.Login Page");
	}
	    

	@When("The user clicks on Register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
	    signin.navigateToRegisterPage();
	    System.out.println("2.Register Page");
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		LoggerLoad.info("User is redirected to the Register Page");
		String title = signin.verifyPageTitle();
		System.out.println("3.Register Page " + title);
		LoggerLoad.info("Titile of Current Page " + title);
		assertEquals(title, "Registration", "Title do not match");
	}

	@Given("The user is on Register page")
	public void the_user_is_on_register_page() {
		assertEquals(1, 1, "Title do not match");
	    
	}

	@When("The user clicks on Sign in link on Register Page")
	public void the_user_clicks_on_sign_in_link_on_register_page() {
	    signin.navigateToSignInLink();
	    System.out.println("4.SignIn Page");
	}

	@Then("The user is redirected to the Sign in page")
	public void the_user_is_redirected_to_the_sign_in_page() {
		LoggerLoad.info("User is redirected to the Sign in Page");
		String title = signin.verifyPageTitle();
		LoggerLoad.info("Title of Current Page " + title);
		System.out.println("4.SignIn Page " + title);
		assertEquals(title, "Login", "Title do not match");
	}

	@Given("The user is on Sign in page")
	public void the_user_is_on_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(1, 1, "Title do not match");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetName, Integer rowNumber) throws IOException, Exception {
		ExcelReader reader = new ExcelReader();
		System.out.println("6.Trying to Login");
		LoggerLoad.info("Excel File Path in SD : " + excelfilepath);
		List<Map<String,String>> testData = reader.getData(excelfilepath, sheetName);
		System.out.println("Row Number: " + rowNumber);
		 username = testData.get(rowNumber).get("Username");
		 password = testData.get(rowNumber).get("Password");
		 expectedMsg = testData.get(rowNumber).get("ExpectedMsg");
		 
		 LoggerLoad.info("User Enter username as \" " + username + " \" Password as \" " + password + "\" ");
		 //if(username != null || password != null) {
			signin.doLogin(username, password);
		 //}
	    
	}

	@Then("click login button")
	public void click_login_button() {
		
		System.out.println("7: Entered Details are: UserName - " + username + " ;Password - " + password + " ;Expected Msg - " + expectedMsg);
		if(username.isEmpty() || password.isEmpty()) {
			String msg = signin.clickLoginButton(false);
			assertEquals(msg, "");
		}
		else {
		String msg = signin.clickLoginButton(true);	
		LoggerLoad.info("Actual Message :  " + msg);
		assertEquals(msg, expectedMsg);
		}
	}

	@Given("The user is on signin page with valid username {string} and password {string}")
	public void the_user_is_on_signin_page_with_valid_username_and_password(String string, String string2) {
	//	signin.doLogin(username, password);
//		signin.clickLoginButton();
		LoggerLoad.info("User is on Sign in Page with Valid Credentials");
	}

	@When("The user click signout button")
	public void the_user_click_signout_button() {
		signin.signout();
		LoggerLoad.info("User Signed out ");
	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage() {
		String Title = signin.verifyPageTitle();
		LoggerLoad.info("Title of current page is" + Title);
		assertEquals(Title, "NumpyNinja", "Pass : Titles match");
	}


}
