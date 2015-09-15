package selenide.apps.bluesource.loginPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenide.core.Constants;
import selenide.core.page.BasePageClass;
import selenide.core.test.BaseTestClass;

public class LoginPage extends BasePageClass {
	// ***************************
	// * LOGIN PAGE CLASS FIElDS *
	// ***************************
	private String username;
	private String password;

	// *******************************
	// * LOGIN PAGE CLASS BUILD AREA *
	// *******************************
	@FindBy(id = "employee_username")
	private WebElement txtUsername;

	@FindBy(id = "employee_password")
	private WebElement txtPassword;

	@FindBy(name = "commit")
	private WebElement btnLogin;

	/**
	 * Dummy constructor
	 */
	public LoginPage() {
	}

	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance
	 * to define the driver to use to find elements
	 * 
	 * @param btc
	 *            - BaseTestClass, passed from the test level when a page class
	 *            is instantiated
	 */
	public LoginPage(BaseTestClass btc) {
		setElementBaseTestClass(btc);
		PageFactory.initElements(getElementDriver(), this);
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************

	// *********************************
	// * LOGIN PAGE CLASS INTERACTIONS *
	// *********************************
	public void login() {
		username = Constants.getCredentials(btc.getApplication(), btc.getUserRole())[0];
		password = Constants.getCredentials(btc.getApplication(), btc.getUserRole())[1];
		setUsername(username);
		setPassword(password);
		clickLogin();
	}

	private void clickLogin() {
		click(btnLogin);
	}

	private void setUsername(String username) {
		set(txtUsername, username);
	}

	private void setPassword(String password) {
		set(txtPassword, password);
	}
}
