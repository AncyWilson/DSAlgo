package pageObjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utilities.ConfigReader;
import utilities.ElementsUtils;


public class DataStructures {
	
	public static WebDriver driver = DriverFactory.getdriver();
	String homeUrl = ConfigReader.getHomePage();
	String loginUrl = ConfigReader.getLoginPage();
	ElementsUtils elementUtil = new ElementsUtils();
	Actions action = new Actions(driver);
	@FindBy(xpath="//a[@href='/login']")WebElement signinLink;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")WebElement getstarted_dataStructs;
	@FindBy(xpath="//a[@href = 'time-complexity']")WebElement timeComplex;
	@FindBy(xpath="//a[@href = '/tryEditor']")WebElement tryHere;
	@FindBy(xpath="//button [@type = 'button']")WebElement run;
	@FindBy(xpath="//pre [@ class = ' CodeMirror-line ']")WebElement tryEditor;
	////textarea[@tabindex='0']
	@FindBy(xpath="//pre[@id='output']")WebElement output;
	
	
	public DataStructures() {
		PageFactory.initElements(driver, this);

	}
	//method to open Signin Page
			public void navigateToSignInLink() {
				signinLink.click();
			}

	public void getLoginPage() {
		driver.get(loginUrl);
	}
	
	public void getStarted(String string) {
		getstarted_dataStructs.click();
		
	}
	
	// Verify the title of the page
	public String verifyPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public void timeCom() {
		timeComplex.click();
	}
	
	public void tryHere() {
		tryHere.click();
	}
	
	//enter the python code using the getCodeFromExcel method from ElementsUtils
		public void enterPythonCode(String sheetName, Integer rowNumber) throws Exception {	
			String code = elementUtil.getCodeFromExcel(sheetName, rowNumber);
			
			elementUtil.enterCode(code, tryEditor);
			
			
		}
		public void clear() {
			tryEditor.clear();
		}
	
	public void run() {
		run.click();
	}
	
	public String getExpectedResult(String sheetName, Integer rowNumber) throws Exception {
		 String expectedResult = elementUtil.getResultfromExcel(sheetName, rowNumber);
		 return expectedResult;
		 
	}
	public String getActualResult() {
		elementUtil.WaitForElement(output);
		return output.getText();
	}
	public String getAlertErrorText() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}
}
