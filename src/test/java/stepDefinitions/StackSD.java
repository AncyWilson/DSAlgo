package stepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.Array;
import pageObjects.DataStructures;
import pageObjects.Queue;
import pageObjects.Stack;


public class StackSD {
	
	Array arrayPage = new Array();
	Queue queuePage = new Queue();
	DataStructures dsIntro = new DataStructures();
	Stack stackpage= new Stack();

	@When("The user clicks the {string} button under Stack")
	public void the_user_clicks_the_button_under_linked_list(String string) {
	    stackpage.clickStackGetStarted();
	}
	
	@When("The user clicks {string} link")
	public void the_user_clicks_link(String string) {
		stackpage.operationsInStack();
	    
	}
	
	@When("The user clicks Implementation link")
	public void the_user_clicks_implementation_link() {
	   stackpage.navigateToImplementation();
	}

	@When("The user clicks Applications link")
	public void the_user_clicks_applications_link() {
	   stackpage.navigateToApplications();
	}
	
		@When("The user select Stack from the dropdown menu")
		public void the_user_select_stack_from_the_dropdown_menu() {
			stackpage.navigateToDropdownStack();
			
		}
}
