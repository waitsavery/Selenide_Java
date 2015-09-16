package selenide.apps.bluesource.pages.navBar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenide.core.page.BasePageClass;
import selenide.core.test.BaseTestClass;

public class NavBar extends BasePageClass {
	// ************************
	// * NAV BAR CLASS FIElDS *
	// ************************

	// ****************************
	// * NAV BAR CLASS BUILD AREA *
	// ****************************
	@FindBy(xpath = "/html/body/header/div/nav/ul/li[1]/a")
	private WebElement lnkAdmin;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[2]/a")
	private WebElement lnkMessageCenter;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[3]/a")
	private WebElement lnkCalendar;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[4]/a")
	private WebElement lnkReporting;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[5]/a")
	private WebElement lnkDirectory;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[6]/a")
	private WebElement lnkProjects;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[7]/a")
	private WebElement lnkEmployess;

	@FindBy(xpath = "/html/body/header/div/nav/ul/li[8]/a")
	private WebElement lnkLogout;

	/**
	 * Dummy constructor
	 */
	public NavBar() {
	}

	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance
	 * to define the driver to use to find elements
	 * 
	 * @param btc
	 *            - BaseTestClass, passed from the test level when a page class
	 *            is instantiated
	 */
	public NavBar(BaseTestClass btc) {
		setElementBaseTestClass(btc);
		PageFactory.initElements(getElementDriver(), this);
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************

	// ******************************
	// * NAV BAR CLASS INTERACTIONS *
	// ******************************

}
