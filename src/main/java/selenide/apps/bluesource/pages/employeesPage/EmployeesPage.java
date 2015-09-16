package selenide.apps.bluesource.pages.employeesPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenide.core.page.BasePageClass;
import selenide.core.test.BaseTestClass;

public class EmployeesPage extends BasePageClass {
	// ******************************
	// * EMPLOYEE PAGE CLASS FIElDS *
	// ******************************

	// **********************************
	// * EMPLOYEE PAGE CLASS BUILD AREA *
	// **********************************
	 @FindBy(id = "ng-app")
	 private WebElement eleEmployeesListSection;

	/**
	 * Dummy constructor
	 */
	public EmployeesPage() {
	}

	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance
	 * to define the driver to use to find elements
	 * 
	 * @param btc
	 *            - BaseTestClass, passed from the test level when a page class
	 *            is instantiated
	 */
	public EmployeesPage(BaseTestClass btc) {
		setElementBaseTestClass(btc);
		PageFactory.initElements(getElementDriver(), this);
		verifyPageLoaded();
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************

	// ************************************
	// * EMPLOYEE PAGE CLASS INTERACTIONS *
	// ************************************
	private void verifyPageLoaded(){
		sync(eleEmployeesListSection, syncTypes.visible, true);
	}
}
