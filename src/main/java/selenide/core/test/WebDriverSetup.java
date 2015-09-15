package selenide.core.test;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSetup {
	// *****************
	// * DRIVER FIElDS *
	// *****************
	// Define a base driver from which all extending classes will inherit
	private WebDriver driver;
	// Define test attributes
	private String browserType;
	private String browserVersion;
	private String operatingSystem;
	private String environment;
	private String runLocation;

	// *********************
	// * DRIVER BUILD AREA *
	// *********************
	public WebDriverSetup() {
		setBrowserType("firefox");
		setBrowserVersion("");
		setOperatingSystem("windows");
		setEnvironment("stage");
		setRunLocation("");
		generateDriver();
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************
	// Define getter/setter for the base driver
	/**
	 * @summary sets the base webdriver for the test
	 * @param driver
	 *            - WebDriver, current test WebDriver
	 */
	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @summary gets the base webdriver for the test
	 * @return base WebDriver
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	// Define getter/setter for the browser type
	/**
	 * @summary sets the browser under test
	 * @param browserType
	 *            - String, browser under test
	 */
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	/**
	 * @summary gets the browser under test
	 * @return String, browser type under test
	 */
	public String getBrowserType() {
		return this.browserType;
	}

	// Define getter/setter for the browser version
	/**
	 * @summary sets the browser version under test
	 * @param browserVersion
	 *            - String, browser version under test
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	/**
	 * @summary gets the browser version under test
	 * @return String, browser version under test
	 */
	public String getBrowserVersion() {
		return this.browserVersion;
	}

	// Define getter/setter for the operating system
	/**
	 * @summary set the operating system under test
	 * @param operatingSystem
	 *            - String, operating system under test
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @summary gets the operating system under test
	 * @return - String, operating system under test
	 */
	public String getOperatingSystem() {
		return this.operatingSystem;
	}

	// Define getter/setter for the environment
	/**
	 * @summary sets the environment in which to test
	 * @param environment
	 *            - String, environment in which to test
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	/**
	 * @summary gets the environment un which to test
	 * @return String, environment in which to test
	 */
	public String getEnvironment() {
		return this.environment;
	}

	// Define getter/setter for the run location
	/**
	 * @summary sets the test execution run location
	 * @param runLocation
	 *            - String, run location ("local" or "remote")
	 */
	public void setRunLocation(String runLocation) {
		this.runLocation = runLocation;
	}

	/**
	 * @summary gets the test execution run location
	 * @return String, test execution run location
	 */
	public String getRunLocation() {
		return this.runLocation;
	}

	// ***********************
	// * DRIVER INTERACTIONS *
	// ***********************
	/**
	 * @summary closes all windows for a given WebDriver and, if testing with
	 *          chorme on windows, will ensure that no chrome or chromedriver
	 *          processes remain before the test ends
	 * @param driver
	 *            - WebDriver, driver for which to close browsers as well as the
	 *            driver itself
	 */
	public void closeAllBrowsersAndQuitDriver(WebDriver driver) {
		// Grab all window handles for the driver
		Set<String> windowHandles = driver.getWindowHandles();
		// Iterate through each handle and close them
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			driver.close();
		}
		// Quit the driver
		driver.quit();

		// If testing on windows with chrome, ensure no chrome or chromedriver
		// processes remian before ending the test
		if (getBrowserType().equalsIgnoreCase("chrome")) {
			if (getOperatingSystem().equalsIgnoreCase("windows")) {
				try {
					Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
					Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
				} catch (IOException ioe) {
					System.out.println("ERROR: Unable to close chrome drivers and browsers.");
				}
			}
		}
	}

	/**
	 * @summary generates a WebDriver based on the browser type under test
	 */
	private void generateDriver() {
		switch (getBrowserType().toLowerCase()) {
		case "firefox":
			setDriver(new FirefoxDriver());
			break;
		case "iexplore":
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\temp\\workspace\\Selenium_Java\\src\\main\\java\\selenium\\core\\drivers\\IEDriverServer.exe");
			setDriver(new InternetExplorerDriver());
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\temp\\workspace\\Selenium_Java\\src\\main\\java\\selenium\\core\\drivers\\chromedriver.exe");
			setDriver(new ChromeDriver());
			break;
		default:
			break;
		}
	}
}
