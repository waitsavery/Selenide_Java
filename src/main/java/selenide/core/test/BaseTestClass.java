package selenide.core.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import selenide.utils.Constants;

public class BaseTestClass extends WebDriverSetup {
	// **************************
	// * BASE TEST CLASS FIELDS *
	// **************************
	private long implicitWaitTimeout;
	private long pageLoadTimeout;
	private long scriptTimeout;
	private int defaultTestTimeout;
	private String application;
	private String userRole;

	// ******************************
	// * BASE TEST CLASS BUILD AREA *
	// ******************************
	public BaseTestClass() {
		setApplication("bluesource");
		setUserRole("company admin");
		manageDriver();
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************
	// Define getter/setter for the implicit wait timeout
	/**
	 * @summary sets the timeout for the implicit wait, which is used to define
	 *          the amount of time the driver will search for an element if it
	 *          is not immediately located
	 * @param timeout
	 *            - long, timeout
	 */
	public void setImplicitWaitTimeout(long timeout) {
		this.implicitWaitTimeout = timeout;
		getDriver().manage().timeouts().implicitlyWait(getImplicitWaitTimeout(), TimeUnit.SECONDS);
	}

	/**
	 * @summary gets the timeout for the implicit wait
	 * @return long, implicit wait timeout
	 */
	public long getImplicitWaitTimeout() {
		return this.implicitWaitTimeout;
	}

	// Define getter/setter for the page load timeout
	/**
	 * @summary sets the page load timeout, which is used to define the amount
	 *          of time the driver will wait for a given page to completely load
	 * @param timeout
	 *            - long, timeout
	 */
	public void setPageLoadTimeout(long timeout) {
		this.pageLoadTimeout = timeout;
		getDriver().manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
	}

	/**
	 * @summary gets the timeout for the page to be loaded
	 * @return long, page load timeout
	 */
	public long getPageLoadTimeout() {
		return this.pageLoadTimeout;
	}

	// Define getter/setter for the script timeout
	/**
	 * @summary sets the script timeout, which is used to define the amount of
	 *          time the driver will wait for a command from the test
	 * @param timeout
	 *            - long, timeout
	 */
	public void setScriptTimeout(long timeout) {
		this.pageLoadTimeout = timeout;
		getDriver().manage().timeouts().setScriptTimeout(getScriptTimeout(), TimeUnit.SECONDS);
	}

	/**
	 * @summary gets the timeout for the script to send a command
	 * @return long, script timeout
	 */
	public long getScriptTimeout() {
		return this.scriptTimeout;
	}

	// Define getter/setter for the default test timeout
	/**
	 * @summary sets a default test timeout, intended to be used by the user for
	 *          custom time-restricted testing (i.e. custom loops that sync to a
	 *          certain behavior)
	 * @param timeout
	 *            int, default test timeout
	 */
	public void setDefaultTestTimeout(int timeout) {
		this.defaultTestTimeout = timeout;
	}

	/**
	 * @summary gets the default test timeout
	 * @return int, default test timeout
	 */
	public int getDefaultTestTimeout() {
		return this.defaultTestTimeout;
	}

	/**
	 * @summary sets all timeouts for the driver, intended to be utilized in the
	 *          base test class constructor to initialize driver timeouts
	 */
	private void setTestTimeouts() {
		setImplicitWaitTimeout(Constants.getImplicitWaitTimeout());
		setPageLoadTimeout(Constants.getPageLoadTimeout());
		setScriptTimeout(Constants.getScriptTimeout());
		setDefaultTestTimeout(Constants.getDefaultTestTimeout());
	}

	// Define getter/setter for the application
	/**
	 * @summary sets the application under test; used to determine URL,
	 *          credentials, etc
	 * @param application
	 *            - String, application under test
	 */
	public void setApplication(String application) {
		this.application = application;
	}

	/**
	 * @summary gets the application under test
	 * @return String, application under test
	 */
	public String getApplication() {
		return this.application;
	}

	// Define getter/setter for the user role
	/**
	 * @summary sets the user role; used to determine credentials
	 * @param role
	 *            - String, role to use for testing
	 */
	public void setUserRole(String role) {
		this.userRole = role;
	}

	/**
	 * @summary gets the user role
	 * @return String, user role
	 */
	public String getUserRole() {
		return this.userRole;
	}

	public BaseTestClass getBaseTestClass() {
		return this;
	}

	// ********************************
	// * BASE TEST CLASS INTERACTIONS *
	// ********************************
	/**
	 * @summary sets initial driver timeouts and manages other driver properties
	 */
	private void manageDriver() {
		setTestTimeouts();
		getDriver().manage().timeouts().implicitlyWait(getImplicitWaitTimeout(), TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
		getDriver().manage().timeouts().setScriptTimeout(getScriptTimeout(), TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}

	// ****************************
	// * TestNG Annotated Methods *
	// ****************************
	@BeforeTest
	/**
	 * @summary contains behavior to be performed prior to any test method
	 */
	public void beforeTest() {
		getDriver().get(Constants.getURL(getApplication(), getEnvironment()));
	}

	@AfterTest
	/**
	 * @summary contains behavior to be performed after any test method
	 */
	public void afterTest() {
		closeAllBrowsersAndQuitDriver(getDriver());
	}
}
